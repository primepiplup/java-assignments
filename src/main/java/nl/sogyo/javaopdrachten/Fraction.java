package nl.sogyo.javaopdrachten;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
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

    public Fraction add(int numberToAdd) {
        numberToAdd = numberToAdd * denominator;
        int newNumerator = numberToAdd + numerator;
        return new Fraction(newNumerator, denominator);
    }

    public Fraction add(Fraction fractionToAdd) {
        int fractionToAddDenominator = fractionToAdd.getDenominator() * denominator;
        int fractionToAddNumerator = fractionToAdd.getNumerator() * denominator;
        int tempDenominator = denominator * fractionToAdd.getDenominator();
        int tempNumerator = numerator * fractionToAdd.getDenominator();
        Fraction addedFraction = new Fraction(fractionToAddNumerator + tempNumerator, tempDenominator);
        addedFraction.reduce();
        return addedFraction;
    }

    private void reduce() {
        int greatestCommonFactor = getGreatestCommonFactor();
        numerator = numerator / greatestCommonFactor;
        denominator = denominator / greatestCommonFactor;
    }

    private int getGreatestCommonFactor() {
        Prime prime = new Prime();
        int[] numeratorPrimeFactors = prime.getPrimeFactors(numerator);
        int[] denominatorPrimeFactors = prime.getPrimeFactors(denominator);
        int commonFactor = 0;
        for(int i = 0; i < numeratorPrimeFactors.length; i++) {
            if(isAInB(numeratorPrimeFactors[i], denominatorPrimeFactors)) {
                commonFactor = numeratorPrimeFactors[i];
            }
        }
        int occurrences = getNumberOfOccurrencesInBoth(commonFactor, numeratorPrimeFactors, denominatorPrimeFactors);
        return power(commonFactor, occurrences);
    }

    private int power(int base, int exponent) {
        int accumulator = 1;
        for(int i = 0; i < exponent; i++) {
            accumulator *= base;
        }
        return accumulator;
    }

    private int getNumberOfOccurrencesInBoth(int number, int[] arrayA, int[] arrayB) {
        int amountNumberInA = getNumberOfOccurrences(number, arrayA);
        int amountNumberInB = getNumberOfOccurrences(number, arrayB);
        if(amountNumberInA < amountNumberInB) {
            return amountNumberInA;
        } else {
            return amountNumberInB;
        }
    }

    private int getNumberOfOccurrences(int number, int[] array){
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(number == array[i]) {
                count++;
            }
        }
        return count;
    }

    private Boolean isAInB(int number, int[] numberArray) {
        for(int i = 0; i < numberArray.length; i++) {
            if(number == numberArray[i]) {
                return true;
            }
        }
        return false;
    }
}
