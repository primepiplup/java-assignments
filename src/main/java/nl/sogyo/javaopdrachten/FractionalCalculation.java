package nl.sogyo.javaopdrachten;

public class FractionalCalculation {
    public static void main(String[] args) {
        Fraction fractionA = new Fraction(1, 3);
        System.out.println(fractionA.toDecimalNotation());
        System.out.println(fractionA.toString());
        Fraction fractionB = new Fraction(1, 6);
        System.out.println(fractionA.add(1));
        System.out.println(fractionA.add(fractionB));
    }
}