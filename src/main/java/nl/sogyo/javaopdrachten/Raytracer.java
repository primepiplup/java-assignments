package nl.sogyo.javaopdrachten;

public class Raytracer {
    public static void main(String[] args) {
        Vector viewpoint = new Vector(0, 0, 0);
        int width = 3840;
        int height = 2560;
        Viewport viewport = new Viewport(new Vector(-36, 27, 50), new Vector(-36, -27, 50), new Vector(36, 27, 50), width, height);
        
        Scene scene = new Scene(viewpoint, viewport);

        scene.addShape(new Sphere(new Vector(0, 0, 150), 50, 0.9));
        scene.addShape(new Sphere(new Vector(20, -20, 100), 10, 0.8));
        scene.addShape(new Plane(new Vector(0, -75, 200), new Vector(0, 1, 0), 0.5));
        scene.addShape(new Plane(new Vector(0, 0, 250), new Vector(0, 0, -1), 0.5));
        
        scene.addLight(new LightSource(new Vector(100, 0, 150), 150));
        scene.addLight(new LightSource(new Vector(30, -30, 80), 100));
        scene.addLight(new LightSource(new Vector(-100, 100, 160), 75));

        SceneRenderer renderer = new SceneRenderer(scene);

        renderer.renderToImage("/home/daan/Projects/raytrace.png");
    }
}
