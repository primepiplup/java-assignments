package nl.sogyo.javaopdrachten;

public interface Shape {
    Vector[] intersect(Line line);
    Vector perpendicularVector(Vector point);
    Material material();
}
