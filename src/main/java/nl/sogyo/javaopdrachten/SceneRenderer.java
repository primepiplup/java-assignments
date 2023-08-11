package nl.sogyo.javaopdrachten;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SceneRenderer {
    private Scene scene;
    private int reflectionDepth;
    private int maxReflectionDepth;

    public SceneRenderer(Scene scene) {
        this.scene = scene;
        this.reflectionDepth = 0;
        this.maxReflectionDepth = 5;
    }

    public void renderToImage(String filepath) {
        int width = scene.getViewport().getWidth();
        int height = scene.getViewport().getHeight();
        Color[][] colorArray = new Color[width][height];
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                colorArray[x][y] = getColor(x, y);
            }
        }
        BufferedImage image = arrayToImage(colorArray);
        saveRender(image, filepath);
    }

    private BufferedImage arrayToImage(Color[][] colorArray) {
        BufferedImage image = new BufferedImage(scene.getViewport().getWidth(), scene.getViewport().getHeight(), BufferedImage.TYPE_INT_ARGB);
        for(int x = 0; x < scene.getViewport().getWidth(); x++) {
            for(int y = 0; y < scene.getViewport().getHeight(); y++) {
                int color = colorArray[x][y].getRGB();
                image.setRGB(x, y, color);
            }
        }
        return image;
    }

    private void saveRender(BufferedImage image, String filepath) {
        File outputfile = new File(filepath);
        System.out.println("Image output to: " + outputfile.getAbsolutePath());
        try {
            ImageIO.write(image, "png", outputfile);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private Color getColor(int x, int y) {
        Line ray = getRay(x, y);
        reflectionDepth = 0;
        return getColorForRay(ray);
    }

    private Color getColorForRay(Line ray) {
        Vector[] intersects = new Vector[0];
        Vector closestIntersect = scene.getViewpoint();
        Shape collisionShape = scene.getShapes().get(0);
        for(Shape s : scene.getShapes()) {
            intersects = s.intersect(ray);
            if(noIntersects(intersects)){
                continue;
            } else {
                Vector closestNewIntersect = getClosestIntersect(intersects);
                if(closestIntersect == scene.getViewpoint() || closer(closestNewIntersect, closestIntersect)) {
                    collisionShape = s;
                    closestIntersect = closestNewIntersect;
                }
            }
        }
        if(closestIntersect == scene.getViewpoint()) {
            return Color.BLACK;
        } else {
            return getColorForCollision(closestIntersect, collisionShape);
        }
    }

    private Color getColorForCollision(Vector intersectPoint, Shape collisionShape) {
        int brightness = 0;
        for(LightSource light : scene.getLights()) {
            Line fromIntersectToLight = new Line(intersectPoint, light.getPosition());
            if(!isObstructed(fromIntersectToLight)) {
                brightness += getLambartianBrightness(collisionShape, intersectPoint, light);
            }
        }
        brightness = Math.min(255, brightness);
        Color collisionColor = getColorFromShapeForBrightness(collisionShape, brightness);
        if(reflectionDepth < maxReflectionDepth && collisionShape.material().reflectivity > 0.01) {
            Color reflectionColor = getColorFromReflection(intersectPoint, collisionShape);
            return combineColorWithReflectionColor(collisionColor, reflectionColor, collisionShape);
        } else {
            return collisionColor;
        }
    }

    private Color combineColorWithReflectionColor(Color collisionColor, Color reflectionColor, Shape collisionShape) {
        double reflectAmount = collisionShape.material().reflectivity;
        double collisionAmount = 1 - reflectAmount;
        int collisionRed = collisionColor.getRed();
        int collisionGreen = collisionColor.getGreen();
        int collisionBlue = collisionColor.getBlue();
        int reflectionRed = reflectionColor.getRed();
        int reflectionGreen = reflectionColor.getGreen();
        int reflectionBlue = reflectionColor.getBlue();
        int red = (int)((collisionRed * collisionAmount) + (reflectionRed * reflectAmount));
        int green = (int)((collisionGreen * collisionAmount) + (reflectionGreen * reflectAmount));
        int blue = (int)((collisionBlue * collisionAmount) + (reflectionBlue * reflectAmount));
        return new Color(red, green, blue, 255);
    }

    private Color getColorFromShapeForBrightness(Shape shape, int brightness) {
        double brightnessProportion = (double)brightness / 255;
        int red = shape.material().color.getRed();
        int green = shape.material().color.getGreen();
        int blue = shape.material().color.getBlue();
        red = (int)(red * brightnessProportion);
        green = (int)(green * brightnessProportion);
        blue = (int)(blue * brightnessProportion);
        Color colorForBrightness = new Color(red, green, blue, 255);
        return colorForBrightness;
    }

    private Color getColorFromReflection(Vector intersectPoint, Shape collisionShape) {
        reflectionDepth += 1;
        Line intersectLine = new Line(scene.getViewpoint(), intersectPoint);
        ParametricLine ray = intersectLine.getParametricForm();
        ParametricLine reflectionRay = ray.reflectAroundNormalAtPoint(intersectPoint, collisionShape.perpendicularVector(intersectPoint));
        Line reflectionLine = reflectionRay.toLine();
        return getColorForRay(reflectionLine);
    }

    private int getLambartianBrightness(Shape shape, Vector intersect, LightSource light) {
        double lightBrightness = light.getBrightness();
        Vector directionToLight = new Line(intersect, light.getPosition()).getParametricForm().direction;
        double dotproduct = Vector.dotProduct(Vector.normalize(shape.perpendicularVector(intersect)), Vector.normalize(directionToLight));
        double brightness = shape.material().diffuseCoefficient * lightBrightness * Math.max(0, dotproduct);
        return (int)brightness;
    }

    private Boolean isObstructed(Line fromIntersectToLight) {
        for(Shape shape : scene.getShapes()) {
            Vector[] intersectors = shape.intersect(fromIntersectToLight);
            if(intersectBetweenIntersectAndLight(intersectors, fromIntersectToLight)) {
                return true;
            }
        }
        return false;
    }

    private Boolean intersectBetweenIntersectAndLight(Vector[] intersectors, Line fromIntersectToLight) {
        if(intersectors.length == 0) {
            return false;
        } else {
            for(Vector intersect : intersectors) {
                ParametricLine rayFromOriginalIntersectToLight = fromIntersectToLight.getParametricForm();
                ParametricLine rayFromLightToNewIntersect = new ParametricLine(fromIntersectToLight.secondPoint, rayFromOriginalIntersectToLight.direction);
                if(!ParametricLine.isVectorAheadOfLine(intersect, rayFromLightToNewIntersect)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean noIntersects(Vector[] intersects) {
        if(intersects.length != 0) {
            return false;
        }
        return true;
    }

    private Vector getClosestIntersect(Vector[] vectorArray) {
        Vector closestIntersect = vectorArray[0];
        for(Vector intersectPoint : vectorArray) {
            if(Vector.distance(scene.getViewpoint(), intersectPoint) < Vector.distance(scene.getViewpoint(), closestIntersect)) {
                closestIntersect = intersectPoint;
            }
        }
        return closestIntersect;
    }

    private Boolean closer(Vector pointA, Vector pointB) {
        return (Vector.distance(scene.getViewpoint(), pointA) < Vector.distance(scene.getViewpoint(), pointB));
    }

    private Line getRay(int x, int y) {
        Coordinate coord = new Coordinate(x, y);
        return new Line(scene.getViewpoint(), scene.getViewport().getVector(coord));
    }
}
