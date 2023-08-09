package nl.sogyo.javaopdrachten;

public class LightSource {
    private Vector position;
    private double brightness;

    public LightSource(Vector position, double brightness) {
        this.position = position;
        this.brightness = brightness;
    }

    public double getBrightness() {
        return brightness;
    }

    public Vector getPosition() {
        return position;
    }
}
