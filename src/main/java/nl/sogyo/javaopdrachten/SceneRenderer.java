package nl.sogyo.javaopdrachten;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class SceneRenderer {
    private Scene scene;

    public SceneRenderer(Scene scene) {
        this.scene = scene;
    }

    public void renderToImage(String filepath) {
        int width = scene.getViewport().getWidth();
        int height = scene.getViewport().getHeight();
        int[][] brightnessArray = new int[width][height];
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                brightnessArray[x][y] = getBrightness(x, y);
            }
        }
        BufferedImage image = arrayToImage(brightnessArray);
        saveRender(image, filepath);
    }

    private BufferedImage arrayToImage(int[][] brightnessArray) {
        BufferedImage image = new BufferedImage(scene.getViewport().getWidth(), scene.getViewport().getHeight(), BufferedImage.TYPE_INT_ARGB);
        for(int x = 0; x < scene.getViewport().getWidth(); x++) {
            for(int y = 0; y < scene.getViewport().getHeight(); y++) {
                int brightness = brightnessArray[x][y];
                Color pixel = new Color(brightness, brightness, brightness, 255);
                image.setRGB(x, y, pixel.getRGB());
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

    private int getBrightness(int x, int y) {
        Line ray = getRay(x, y);
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
            return 0;
        } else {
            return getBrightnessForCollision(closestIntersect, collisionShape);
        }
    }

    private int getBrightnessForCollision(Vector intersectPoint, Shape collisionShape) {
        int brightness = 0;
        for(LightSource light : scene.getLights()) {
            Line fromIntersectToLight = new Line(intersectPoint, light.getPosition());
            if(!isObstructed(fromIntersectToLight)) {
                brightness += getLambartianBrightness(collisionShape, intersectPoint, light);
            }
        }
        return Math.min(255, brightness);
    }

    private int getLambartianBrightness(Shape shape, Vector intersect, LightSource light) {
        double lightBrightness = light.getBrightness();
        Vector directionToLight = new Line(intersect, light.getPosition()).getParametricForm().direction;
        double dotproduct = Vector.dotProduct(Vector.normalize(shape.perpendicularVector(intersect)), Vector.normalize(directionToLight));
        double brightness = shape.diffuseCoefficient() * lightBrightness * Math.max(0, dotproduct);
        return (int)brightness;

    }

    private Boolean isObstructed(Line fromIntersectToLight) {
        for(Shape shape : scene.getShapes()) {
            Vector[] intersectors = shape.intersect(fromIntersectToLight);
            if(intersectors.length != 0) {
                return true;
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
