package nl.sogyo.javaopdrachten;

import java.util.ArrayList;

public class Sphere implements Shape{
    private Vector origin;
    private double radius;
    private double diffuseCoefficient;

    public Sphere(Vector origin, double radius, double diffuseCoefficient) {
        this.origin = origin;
        this.radius = radius;
        this.diffuseCoefficient = diffuseCoefficient;
    }

    public double diffuseCoefficient() {
        return diffuseCoefficient;
    }

    public Vector perpendicularVector(Vector point) {
        Line originToPoint = new Line(origin, point);
        ParametricLine perpendicularLine = originToPoint.getParametricForm();
        return perpendicularLine.direction;
    }

    public Vector[] intersect(Line line) {
        ParametricLine calculationLine = line.getParametricForm();
        Vector originDiff = Vector.minus(calculationLine.origin, origin);
        double a = Vector.dotProduct(calculationLine.direction, calculationLine.direction);
        double b = 2 * Vector.dotProduct(calculationLine.direction, originDiff);
        double c = Vector.dotProduct(originDiff, originDiff) - (radius * radius);
        double discriminant = discriminant(a, b, c);
        
        ArrayList<Vector> vectorList = new ArrayList<Vector>();

        if(discriminant < 0) {
            Vector[] emptyVector = new Vector[0];
            return emptyVector;
        } else if(discriminant == 0) {
            double quadraticResult = getQuadraticResultA(a, b, c, discriminant);
            Vector intersectionPoint = calculationLine.getPoint(quadraticResult);
            if(ParametricLine.isVectorAheadOfLine(intersectionPoint, calculationLine)) {
                vectorList.add(intersectionPoint);
            }
        } else {
            Vector[] intersectionPoints = new Vector[2];
            double quadraticResultA = getQuadraticResultA(a, b, c, discriminant);
            double quadraticResultB = getQuadraticResultB(a, b, c, discriminant);
            intersectionPoints[0] = calculationLine.getPoint(quadraticResultA);
            intersectionPoints[1] = calculationLine.getPoint(quadraticResultB);
            if(ParametricLine.isVectorAheadOfLine(intersectionPoints[0], calculationLine)) {
                vectorList.add(intersectionPoints[0]);
            }
            if(ParametricLine.isVectorAheadOfLine(intersectionPoints[1], calculationLine)) {
                vectorList.add(intersectionPoints[1]);
            }
        }
        Vector[] intersectionPoints = new Vector[vectorList.size()];
        vectorList.toArray(intersectionPoints);
        return intersectionPoints;
    }

    private double getQuadraticResultA(double a, double b, double c, double discriminant) {
        return ((-1 * b) + Math.sqrt(discriminant)) / (2 * a);
    }

    private double getQuadraticResultB(double a, double b, double c, double discriminant) {
        return ((-1 * b) - Math.sqrt(discriminant)) / (2 * a);
    }

    private double discriminant(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }
}
