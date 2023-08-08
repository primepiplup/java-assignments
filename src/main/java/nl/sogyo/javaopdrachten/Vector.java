package nl.sogyo.javaopdrachten;

public class Vector {
    public float x;
    public float y;
    public float z;

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector difference(Vector vectorA, Vector vectorB) {
        return new Vector(vectorA.x - vectorB.x, vectorA.y - vectorB.y, vectorA.z - vectorB.z);
    }
}
