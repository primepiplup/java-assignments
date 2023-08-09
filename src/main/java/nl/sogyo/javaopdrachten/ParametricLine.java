package nl.sogyo.javaopdrachten;

public class ParametricLine {
    Vector origin;
    Vector direction;

    public ParametricLine(Vector origin, Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }

    public void checkForIntersection(ParametricLine intersector) {
        //Not functional for now :(
        Vector a = Vector.crossProduct(direction, intersector.direction);

        double dot = Vector.dotProduct(a, a);

        if(dot == 0){
            System.out.println("No intersection");
        }

        Vector b = Vector.crossProduct(Vector.minus(origin, intersector.origin), intersector.direction);

        double t = Vector.dotProduct(a, b) / dot;
        System.out.println(t);

        Vector intersectionPoint = getPoint(t);
        System.out.println(intersectionPoint);
    }

    public Vector getPoint(double lineScalar) {
        return new Vector(  origin.x + direction.x * lineScalar, 
                            origin.y + direction.y * lineScalar, 
                            origin.z + direction.z * lineScalar);
    }
}
