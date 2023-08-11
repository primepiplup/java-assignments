package nl.sogyo.javaopdrachten;

public class ParametricLine {
    Vector origin;
    Vector direction;

    public ParametricLine(Vector origin, Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }

    public static Boolean isVectorAheadOfLine(Vector vectorToTest, ParametricLine ray) {
        Line lineToVector = new Line(ray.origin, vectorToTest);
        ParametricLine rayToVector = lineToVector.getParametricForm();
        double directionDifferenceAngle = Vector.angle(ray.direction, rayToVector.direction);
        double distanceFromOrigin = Vector.distance(ray.origin, vectorToTest);
        return (directionDifferenceAngle < 90 && distanceFromOrigin > 1);
    }

    public Vector getPoint(double lineScalar) {
        return new Vector(  origin.x + direction.x * lineScalar, 
                            origin.y + direction.y * lineScalar, 
                            origin.z + direction.z * lineScalar);
    }

    public ParametricLine reflectAroundNormalAtPoint(Vector reflectionPoint, Vector normalVector) {
        Vector normalizedNormal = Vector.normalize(normalVector);
        double dotProduct = 2 * Vector.dotProduct(direction, normalizedNormal);
        return new ParametricLine(reflectionPoint, Vector.minus(direction, Vector.multiply(normalizedNormal, dotProduct)));
    }

    public Line toLine() {
        Vector firstpoint = origin;
        Vector secondpoint = getPoint(1);
        return new Line(firstpoint, secondpoint);
    }
}
