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
        for(int x = 0; x < viewport.getWidth(); x++) {
            for(int y = 0; y < viewport.getHeight(); y++) {
                getColor(x, y);
            }
        }
    }

    public void getColor(int x, int y) {
        getRay(x, y);
    }

    public Line getRay(int x, int y) {
        Coordinate coord = new Coordinate(x, y);
        return new Line(viewpoint, viewport.getVector(coord));
    }
}
