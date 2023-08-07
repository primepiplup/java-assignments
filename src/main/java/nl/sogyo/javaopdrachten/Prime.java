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
