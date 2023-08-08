package nl.sogyo.javaopdrachten;

public class Line {
    Vector startingPoint;
    Vector secondPoint;

    public Line(Vector startingPoint, Vector secondPoint) {
        this.startingPoint = startingPoint;
        this.secondPoint = secondPoint;
    }

    public ParametricLine getParametricForm() {
        Vector origin = startingPoint;
        Vector direction = Vector.difference(startingPoint, secondPoint);
        return new ParametricLine(origin, direction);
    }
}
