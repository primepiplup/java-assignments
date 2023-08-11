package nl.sogyo.javaopdrachten;

import java.awt.Color;

public class Material {
    double diffuseCoefficient;
    double reflectivity;
    Color color;
    
    public Material(double diffuseCoefficient, double reflectivity, Color color) {
        this.diffuseCoefficient = diffuseCoefficient;
        this.reflectivity = reflectivity;
        this.color = color;
    }
}
