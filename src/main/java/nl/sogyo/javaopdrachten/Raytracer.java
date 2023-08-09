package nl.sogyo.javaopdrachten;

public class Raytracer {
    public static void main(String[] args) {
        Vector vectorA = new Vector(0.0, 0.0, 1.0);
        Vector vectorB = new Vector(1.0, 0.0, 0.0);
        System.out.println(Vector.angle(vectorA, vectorB));

        ParametricLine lineA = new ParametricLine(new Vector(5, 8, -1), new Vector(1, 3, -2));
        ParametricLine lineB = new ParametricLine(new Vector(-8, 5, 3), new Vector(5, -3, 1));
        lineA.checkForIntersection(lineB);
    }
}
