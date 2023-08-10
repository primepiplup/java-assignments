package nl.sogyo.javaopdrachten;

import java.util.ArrayList;

public class Raytracer {
    public static void main(String[] args) {
        Vector viewpoint = new Vector(0, 0, 0);
        int width = 600;
        int height = 450;
        Viewport viewport = new Viewport(new Vector(-36, 27, 50), new Vector(-36, -27, 50), new Vector(36, 27, 50), width, height);
        
        ArrayList<Shape> shapeList = new ArrayList<Shape>();
        shapeList.add(new Sphere(new Vector(0, 0, 150), 50));
        shapeList.add(new Sphere(new Vector(20, -20, 100), 10));
        
        ArrayList<LightSource> lightList = new ArrayList<LightSource>();
        lightList.add(new LightSource(new Vector(100, 0, 150), 125));
        lightList.add(new LightSource(new Vector(0, -60, 120), 50));

        Scene scene = new Scene(viewpoint, viewport, shapeList, lightList);
        scene.render();
    }
}
