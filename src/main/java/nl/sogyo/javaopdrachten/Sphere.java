package nl.sogyo.javaopdrachten;

public class Sphere implements Shape{
    private Vector origin;
    private double radius;

    public Sphere(Vector origin, double radius) {
        this.origin = origin;
        this.radius = radius;
    }

    public Vector[] intersect(Line line) {
        ParametricLine calculationLine = line.getParametricForm();
        Vector originDiff = Vector.minus(calculationLine.origin, origin);
        double a = Vector.dotProduct(calculationLine.direction, calculationLine.direction);
        double b = 2 * Vector.dotProduct(calculationLine.direction, originDiff);
        double c = Vector.dotProduct(originDiff, originDiff) - (radius * radius);
        double discriminant = discriminant(a, b, c);
        
        if(discriminant < 0) {
            Vector[] emptyVector = new Vector[0];
            return emptyVector;
        } else if(discriminant == 0) {
            Vector[] intersectionPoint = new Vector[1];
            double quadraticResult = getQuadraticResultA(a, b, c, discriminant);
            intersectionPoint[0] = calculationLine.getPoint(quadraticResult);
            return intersectionPoint;
        } else {
            Vector[] intersectionPoints = new Vector[2];
            double quadraticResultA = getQuadraticResultA(a, b, c, discriminant);
            double quadraticResultB = getQuadraticResultB(a, b, c, discriminant);
            intersectionPoints[0] = calculationLine.getPoint(quadraticResultA);
            intersectionPoints[1] = calculationLine.getPoint(quadraticResultB);
            return intersectionPoints;
        }
    }

    public double getQuadraticResultA(double a, double b, double c, double discriminant) {
        return ((-2 * b) + Math.sqrt(discriminant)) / (2 * a);
    }

    public double getQuadraticResultB(double a, double b, double c, double discriminant) {
        return ((-2 * b) - Math.sqrt(discriminant)) / (2 * a);
    }

    public double discriminant(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }
}
