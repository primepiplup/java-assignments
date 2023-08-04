package nl.sogyo.javaopdrachten;

public class Fraction {
    int numerator;
    int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double toDecimalNotation() {
        double n = numerator;
        double d = denominator;
        return n/d;
    }

    public String toString() {
        String numeratorString = String.valueOf(numerator);
        String denominatorString = String.valueOf(denominator);
        return numeratorString + "/" + denominatorString;
    }
}
