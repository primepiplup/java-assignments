package nl.sogyo.javaopdrachten;

import java.util.ArrayList;

public class Scene {
    private Vector viewpoint;
    private Viewport viewport;
    private ArrayList<Shape> shapeList;
    private ArrayList<LightSource> lightList;

    public Scene(Vector viewpoint, Viewport viewport) {
        this.viewpoint = viewpoint;
        this.viewport = viewport;
        this.shapeList = new ArrayList<Shape>();
        this.lightList = new ArrayList<LightSource>();
    }

    public void addShape(Shape shape) {
        shapeList.add(shape);
    }

    public void addLight(LightSource light) {
        lightList.add(light);
    }

    public ArrayList<Shape> getShapes() {
        return shapeList;
    }
    
    public ArrayList<LightSource> getLights() {
        return lightList;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public Vector getViewpoint() {
        return viewpoint;
    }
}
