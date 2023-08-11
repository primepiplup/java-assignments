package nl.sogyo.javaopdrachten;

public class Plane implements Shape {
    private Material material;
    private Vector origin;
    private Vector normal;

    public Plane(Vector origin, Vector normal, Material material) {
        this.origin = origin;
        this.normal = normal;
        this.material = material;
    }

    public Vector perpendicularVector(Vector point) {
        return normal;
    }
    
    public Vector[] intersect(Line line) {
        ParametricLine ray = line.getParametricForm();
        if(Vector.dotProduct(normal, ray.direction) != 0) {
            double rayscalar = Vector.dotProduct(Vector.minus(origin, ray.origin), normal) / Vector.dotProduct(ray.direction, normal);
            Vector[] intersect = new Vector[1];
            Vector intersectPoint = ray.getPoint(rayscalar);
            if(ParametricLine.isVectorAheadOfLine(intersectPoint, ray)){
                intersect[0] = intersectPoint;
                return intersect;
            }
        }
        return new Vector[0];
    }

    public Material material() {
        return material;
    }
}
