package nl.sogyo.javaopdrachten;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Scene {
    Vector viewpoint;
    Viewport viewport;
    ArrayList<Shape> shapeList;
    ArrayList<LightSource> lightList;

    public Scene(Vector viewpoint, Viewport viewport, ArrayList<Shape> shapeList, ArrayList<LightSource> lightList) {
        this.viewpoint = viewpoint;
        this.viewport = viewport;
        this.shapeList = shapeList;
        this.lightList = lightList;
    }

    public void render() {
        int width = viewport.getWidth();
        int height = viewport.getHeight();
        int[][] brightnessArray = new int[width][height];
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                brightnessArray[x][y] = getBrightness(x, y);
            }
        }
        BufferedImage image = arrayToImage(brightnessArray);
        saveRender(image);
    }

    public BufferedImage arrayToImage(int[][] brightnessArray) {
        BufferedImage image = new BufferedImage(viewport.getWidth(), viewport.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for(int x = 0; x < viewport.getWidth(); x++) {
            for(int y = 0; y < viewport.getHeight(); y++) {
                int brightness = brightnessArray[x][y];
                Color pixel = new Color(brightness, brightness, brightness, 255);
                image.setRGB(x, y, pixel.getRGB());
            }
        }
        return image;
    }

    public void saveRender(BufferedImage image) {
        File outputfile = new File("/home/daan/Projects/raytrace.png");
        System.out.println("Image output to: " + outputfile.getAbsolutePath());
        try {
            ImageIO.write(image, "png", outputfile);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public int getBrightness(int x, int y) {
        Line ray = getRay(x, y);
        ArrayList<Vector[]> intersectList = new ArrayList<Vector[]>();
        for(Shape s : shapeList) {
            intersectList.add(s.intersect(ray));
        }
        if(noIntersects(intersectList)) {
            return 0;
        } else {
            Vector closestIntersect = getClosestIntersect(intersectList);
            return getBrightnessForCollision(closestIntersect);
        }
    }

    public Boolean noIntersects(ArrayList<Vector[]> intersectList) {
        for(Vector[] vectorArray : intersectList) {
            if(vectorArray.length != 0) {
                return false;
            }
        }
        return true;
    }

    public Vector getClosestIntersect(ArrayList<Vector[]> intersectList) {
        ArrayList<Vector> closeIntersectPerShape = new ArrayList<Vector>();
        for(Vector[] vectorArray : intersectList) {
            if(vectorArray.length == 0) {
                continue;
            } else {
                closeIntersectPerShape.add(getClosestIntersect(vectorArray));
            }
        }
        Vector[] closeIntersectArray = new Vector[closeIntersectPerShape.size()];
        closeIntersectPerShape.toArray(closeIntersectArray);
        return getClosestIntersect(closeIntersectArray);
    }

    public Vector getClosestIntersect(Vector[] vectorArray) {
        Vector closestIntersect = vectorArray[0];
        for(Vector intersectPoint : vectorArray) {
            if(Vector.distance(viewpoint, intersectPoint) < Vector.distance(viewpoint, closestIntersect)) {
                closestIntersect = intersectPoint;
            }
        }
        return closestIntersect;
    }

    public int getBrightnessForCollision(Vector intersectPoint) {
        int brightness = 0;
        for(LightSource light : lightList) {
            Line fromIntersectToLight = new Line(intersectPoint, light.getPosition());
            if(!isObstructed(fromIntersectToLight)) {
                brightness += light.getBrightness();
            }
        }
        return brightness;
    }

    public Boolean isObstructed(Line fromIntersectToLight) {
        for(Shape shape : shapeList) {
            Vector[] intersectors = shape.intersect(fromIntersectToLight);
            if(intersectors.length != 0) {
                return true;
            }
        }
        return false;
    }

    public Line getRay(int x, int y) {
        Coordinate coord = new Coordinate(x, y);
        return new Line(viewpoint, viewport.getVector(coord));
    }
}
