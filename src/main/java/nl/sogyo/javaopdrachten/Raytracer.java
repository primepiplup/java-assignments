package nl.sogyo.javaopdrachten;

import java.util.ArrayList;

public class Raytracer {
    public static void main(String[] args) {
        Vector viewpoint = new Vector(0, 0, 0);
        int width = 500;
        int height = 400;
        Viewport viewport = new Viewport(new Vector(-200, 150, 50), new Vector(-200, -150, 50), new Vector(200, 150, 50), width, height);
        
        ArrayList<Shape> shapeList = new ArrayList<Shape>();
        shapeList.add(new Sphere(new Vector(50, -20, 50), 50));
        
        ArrayList<LightSource> lightList = new ArrayList<LightSource>();
        lightList.add(new LightSource(new Vector(500, 500, 155), 100));
        lightList.add(new LightSource(new Vector(500, -100, 75), 50));

        Scene scene = new Scene(viewpoint, viewport, shapeList, lightList);
        scene.render();
    }
}
