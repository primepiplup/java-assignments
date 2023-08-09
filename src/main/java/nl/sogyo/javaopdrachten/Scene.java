package nl.sogyo.javaopdrachten;

import java.util.ArrayList;

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

        double[][] brightnessArray = new double[width][height];

        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                //brightnessArray[x][y] = 
                getBrightness(x, y);
            }
        }
    }

    public void getBrightness(int x, int y) {
        Line ray = getRay(x, y);
        ArrayList<Vector[]> intersectList = new ArrayList<Vector[]>();
        for(Shape s : shapeList) {
            intersectList.add(s.intersect(ray));
        }
    }

    public Line getRay(int x, int y) {
        Coordinate coord = new Coordinate(x, y);
        return new Line(viewpoint, viewport.getVector(coord));
    }
}
