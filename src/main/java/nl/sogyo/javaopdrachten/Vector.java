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
    
    public String toString() {
        String vectorString = "(" + Double.toString(x)+ ", " + Double.toString(y) + ", " + Double.toString(z) + ")";
        return vectorString;
    }

    public static Boolean isOverlapping(Vector vectorA, Vector vectorB) {
        if(vectorA.x != vectorB.x) {
            return false;
        } else if(vectorA.y != vectorB.y) {
            return false;
        } else if(vectorA.z != vectorB.z) {
            return false;
        } else {
            return true;
        }
    }

    public static double distance(Vector vectorA, Vector vectorB) {
        Vector displacementVector = displacement(vectorA, vectorB);
        double distance = magnitude(displacementVector);
        return distance;
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

    public static Vector crossProduct(Vector vectorA, Vector vectorB) {
        return new Vector(  vectorA.y * vectorB.z - vectorA.z * vectorB.y,
                            vectorA.z * vectorB.x - vectorA.x * vectorB.z,
                            vectorA.x * vectorB.y - vectorA.y * vectorB.x);
    }

    public static Vector displacement(Vector vectorA, Vector vectorB) {
        return new Vector(vectorB.x - vectorA.x, vectorB.y - vectorA.y, vectorB.z - vectorA.z);
    }

    public static Vector minus(Vector vectorA, Vector vectorB) {
        return new Vector(vectorA.x - vectorB.x, vectorA.y - vectorB.y, vectorA.z - vectorB.z);
    }

    public static Vector add(Vector vectorA, Vector vectorB) {
        return new Vector(vectorA.x + vectorB.x, vectorA.y + vectorB.y, vectorA.z + vectorB.z);
    }
}
