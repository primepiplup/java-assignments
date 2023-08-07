package nl.sogyo.javaopdrachten;

public class FractionalCalculation {
    public static void main(String[] args) {
        Fraction fractionA = new Fraction(1, 3);
        System.out.println(fractionA.toDecimalNotation());
        System.out.println(fractionA.toString());
        Fraction fractionB = new Fraction(1, 6);
        System.out.println(fractionA.add(1));
        System.out.println(fractionA.add(fractionB));
        System.out.println(new Fraction(4, 3).subtract(1));
        System.out.println(new Fraction(1, 2).subtract(new Fraction(1, 6)));
        
    }
}