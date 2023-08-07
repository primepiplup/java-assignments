package nl.sogyo.javaopdrachten;

public class FractionalCalculation {
    public static void main(String[] args) {
        Fraction testFraction = new Fraction(1, 3);
        System.out.println(testFraction.toDecimalNotation());
        System.out.println(testFraction.toString());
        Prime prime = new Prime();
        System.out.println(prime.getPrime());
        prime.nextPrime();
        System.out.println(prime.getPrime());
        prime.nextPrime();
        System.out.println(prime.getPrime());
        prime.nextPrime();
        System.out.println(prime.getPrime());
        prime.nextPrime();
        System.out.println(prime.getPrime());
        prime.nextPrime();
        System.out.println(prime.getPrime());
    }
}