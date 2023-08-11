package nl.sogyo.javaopdrachten;

import java.awt.Color;

public class Material {
    double diffuseCoefficient;
    Color color;
    
    public Material(double diffuseCoefficient, Color color) {
        this.diffuseCoefficient = diffuseCoefficient;
        this.color = color;
    }
}
