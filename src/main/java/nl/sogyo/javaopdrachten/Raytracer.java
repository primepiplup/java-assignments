package nl.sogyo.javaopdrachten;

import java.util.ArrayList;

public class Raytracer {
    public static void main(String[] args) {
        Vector viewpoint = new Vector(0, 0, 0);
        Viewport viewport = new Viewport(new Vector(-400, 300, 50), new Vector(-400, -300, 50), new Vector(400, 300, 50), 400, 300);
        
        ArrayList<Shape> shapeList = new ArrayList<Shape>();
        shapeList.add(new Sphere(new Vector(0, 0, 100), 100));
        shapeList.add(new Sphere(new Vector(100, 150, 130), 50));
        
        ArrayList<LightSource> lightList = new ArrayList<LightSource>();
        lightList.add(new LightSource(new Vector(500, 500, 155), 100));
        lightList.add(new LightSource(new Vector(500, -100, 75), 50));

        Scene scene = new Scene(viewpoint, viewport, shapeList, lightList);
        scene.render();
    }
}
