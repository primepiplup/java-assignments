package nl.sogyo.javaopdrachten;

public class Viewport {
    private Vector topLeftCorner;
    private Vector bottomLeftCorner;
    private Vector topRightCorner;
    private double width;
    private double height;

    public Viewport(Vector topLeftCorner, Vector bottomLeftCorner, Vector topRightCorner, double width, double height) {
        this.topLeftCorner = topLeftCorner;
        this.bottomLeftCorner = bottomLeftCorner;
        this.topRightCorner = topRightCorner;
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Boolean isWithinViewport(Coordinate coord) {
        if(coord.x >= width || coord.y >= height) {
            return false;
        }
        return true;
    }

    public Vector getVector(Coordinate coord) {
        double xProportion = width / coord.x;
        double yProportion = height / coord.y;
        Vector proportionTopEdge = getProportionOfTopEdge(xProportion);
        Vector proportionLeftEdge = getProportionOfLeftEdge(yProportion);
        return localAddVector(proportionTopEdge, proportionLeftEdge);
    }

    private Vector localAddVector(Vector vectorA, Vector vectorB) {
        Vector localVectorA = Vector.minus(vectorA, topLeftCorner);
        Vector localVectorB = Vector.minus(vectorB, topLeftCorner);
        Vector combinedLocalVector = Vector.add(localVectorA, localVectorB);
        Vector reglobalizedVector = Vector.add(combinedLocalVector, topLeftCorner);
        return reglobalizedVector;
    }

    private Vector getProportionOfTopEdge(double xProportion) {
        Line topEdge = new Line(topLeftCorner, topRightCorner);
        ParametricLine topEdgeParametric = topEdge.getParametricForm();
        return topEdgeParametric.getPoint(xProportion);
    }
    
    private Vector getProportionOfLeftEdge(double yProportion) {
        Line leftEdge = new Line(topLeftCorner, bottomLeftCorner);
        ParametricLine leftEdgeParametric = leftEdge.getParametricForm();
        return leftEdgeParametric.getPoint(yProportion);
    }
}