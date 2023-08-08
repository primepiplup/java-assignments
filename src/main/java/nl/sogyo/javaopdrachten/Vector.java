package nl.sogyo.javaopdrachten;

public class Vector {
    public double x;
    public double y;
    public double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector difference(Vector vectorA, Vector vectorB) {
        return new Vector(vectorA.x - vectorB.x, vectorA.y - vectorB.y, vectorA.z - vectorB.z);
    }

    public static double angle(Vector vectorA, Vector vectorB) {
        double radians = Math.acos(dotProduct(vectorA, vectorB) / magnitude(vectorA) * magnitude(vectorB));
        return Math.toDegrees(radians);
    }

    public static double magnitude(Vector vector) {
        return Math.sqrt(vector.x * vector.x + vector.y * vector.y + vector.z * vector.z);
    }

    public static double dotProduct(Vector vectorA, Vector vectorB) {
        return vectorA.x * vectorB.x + vectorA.y * vectorB.y + vectorA.z * vectorB.z;
    }
}
