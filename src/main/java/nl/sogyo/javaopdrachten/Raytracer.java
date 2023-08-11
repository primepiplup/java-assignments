package nl.sogyo.javaopdrachten;

import java.awt.Color;

public class Raytracer {
    public static void main(String[] args) {
        Vector viewpoint = new Vector(0, 0, 0);
        int width = 1200;
        int height = 900;
        Viewport viewport = new Viewport(new Vector(-36, 27, 50), new Vector(-36, -27, 50), new Vector(36, 27, 50), width, height);
        
        Scene scene = new Scene(viewpoint, viewport);

        scene.addShape(new Sphere(new Vector(-25, 0, 150), 50, new Material(0.9, 0.0, Color.BLUE)));
        scene.addShape(new Sphere(new Vector(40, -30, 110), 20, new Material(0.8, 0.0, Color.RED)));
        scene.addShape(new Plane(new Vector(0, -60, 200), new Vector(0, 1, 0), new Material(0.9, 0.0, Color.WHITE)));
        scene.addShape(new Plane(new Vector(-150, 0, 300), new Vector(0, 0, -1), new Material(1, 0.0, Color.WHITE)));
        
        //scene.addLight(new LightSource(new Vector(100, 0, 150), 150));
        scene.addLight(new LightSource(new Vector(30, -30, 80), 150));
        //scene.addLight(new LightSource(new Vector(-100, 100, 160), 75));

        SceneRenderer renderer = new SceneRenderer(scene);

        renderer.renderToImage("/home/daan/Projects/raytrace.png");
    }
}
