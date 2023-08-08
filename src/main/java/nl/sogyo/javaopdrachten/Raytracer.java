package nl.sogyo.javaopdrachten;

public class Raytracer {
    public static void main(String[] args) {
        Vector vectorA = new Vector(0.0, 0.0, 1.0);
        Vector vectorB = new Vector(1.0, 0.0, 0.0);
        System.out.println(Vector.angle(vectorA, vectorB));
    }
}
