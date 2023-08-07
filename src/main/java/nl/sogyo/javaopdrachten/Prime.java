package nl.sogyo.javaopdrachten;

import java.util.ArrayList;

public class Prime {
    private ArrayList<Integer> primeList = new ArrayList<Integer>();
    private int currentPrime = 2;

    public Prime() {
        primeList.add(2);
    }

    public int getPrime() {
        return currentPrime;
    }

    public int[] getPrimeFactors(int number) {
        ArrayList<Integer> factorList = new ArrayList<Integer>();
        int primeIndex = 0;
        int numberWithRemovedFactors = number;
        while(multiplied(factorList) != number) {
            if(isNumberDivisibleBy(numberWithRemovedFactors, primeList.get(primeIndex))) {
                factorList.add(primeList.get(primeIndex));
                numberWithRemovedFactors = numberWithRemovedFactors / primeList.get(primeIndex);
            } else {
                primeIndex += 1;
                ensureEnoughPrimesForIndex(primeIndex);
            }
        }
        return getArrayFromArrayList(factorList);
    }

    public int[] getArrayFromArrayList(ArrayList<Integer> numberlist) {
        int[] returnArray = new int[numberlist.size()];
        for(int i = 0; i < numberlist.size(); i++) {
            returnArray[i] = numberlist.get(i);
        }
        return returnArray;
    }

    private int multiplied(ArrayList<Integer> numberList) {
        int total = 1;
        for(int i = 0; i < numberList.size(); i++) {
            total *= numberList.get(i);
        }
        return total;
    }

    private void ensureEnoughPrimesForIndex(int index) {
        while(index >= primeList.size()) {
            nextPrime();
        }
    }

    public void nextPrime() {
        int possiblePrime = currentPrime + 1;
        while(!isPrime(possiblePrime)) {
            possiblePrime += 1;
        }
        currentPrime = possiblePrime;
        primeList.add(possiblePrime);
    }

    public Boolean isPrime(int numberToTest) {
        for(int i = 0; i < primeList.size(); i++) {
            if(isNumberDivisibleBy(numberToTest, primeList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public Boolean isNumberDivisibleBy(int numberToDivide, int divider) {
        return (numberToDivide % divider == 0);
    }
}
