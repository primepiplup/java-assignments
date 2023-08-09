package nl.sogyo.javaopdrachten;

public class Raytracer {
    public static void main(String[] args) {
        Vector viewpoint = new Vector(0, 0, 0);
        Viewport viewport = new Viewport(new Vector(400, 300, 50), new Vector(-400, 300, 50), new Vector(400, -300, 50), 400, 300);
        Sphere sphereA = new Sphere(new Vector(0, 0, 100), 100);
        Sphere sphereB = new Sphere(new Vector(100, 150, 130), 50);
    }
}
