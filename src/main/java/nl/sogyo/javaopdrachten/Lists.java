package nl.sogyo.javaopdrachten;

import java.util.random.*;
import java.util.ArrayList;

public class Lists {
    public static void main(String[] args) {
        //initialize random number generator
        RandomGenerator random = RandomGenerator.getDefault();

        //random list will be initialized with given length
        int length = 10;
        int[] randomList = new int[length];

        //set low and high bound for random population
        int lowBound = 0;
        int highBound = 100;

        for(int i = 0; i < length; i++) {
            //populate list with random numbers
            randomList[i] = random.nextInt(lowBound, highBound);
            System.out.println(randomList[i]);
        }
        
        //print greatest array value
        System.out.print("The highest number is: ");
        System.out.println(getMax(randomList));

        //print lowest 2 numbers
        int n = 2;
        int[] lowestTwo = getNLowest(randomList, n);
        System.out.printf("The lowest %d numbers: \n", n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(lowestTwo[i]);
            sum += lowestTwo[i];
        }
        System.out.printf("The sum of the lowest %d numbers is: %d\n", n, sum);

        //print all even numbers
        System.out.println("All even numbers:");
        for(int i = 0; i < randomList.length; i++){
            if(isEven(randomList[i])){
                System.out.println(randomList[i]);
            }
        }

        //print split arrays for divisible by 2, 3, 5 and the rest
        int[] divisibleByTwo = getDivisibleBy(randomList, 2);
        int[] divisibleByThree = getDivisibleBy(randomList, 3);
        int[] divisibleByFive = getDivisibleBy(randomList, 5);
        System.out.println("Divisible by two:");
        printArray(divisibleByTwo);
        System.out.println("Divisible by three:");
        printArray(divisibleByThree);
        System.out.println("Divisible by five:");
        printArray(divisibleByFive);

        //print list sorted by bubblesort
        bubbleSort(randomList);  //sort in-place
        System.out.println("Bubblesorted list: ");
        for(int i = 0; i < randomList.length; i++) {
            System.out.println(randomList[i]);
        }
    }


    public static boolean isEven(int number){
        return number % 2 == 0;
    }


    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public static int getMax(int[] array){
        int max = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > max) {max = array[i];}
        }
        return max;
    }


    public static int[] getDivisibleBy(int[] array, int divider) {
        /* generalized function to return a list of numbers divisible
         * by some given number without a remainder
         */
        //count number of divisible numbers for correct array size
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] % divider == 0){ count++; }
        }

        //create array and populate with the counted numbers
        int[] accumulator = new int[count];
        for(int i = 0; i < array.length; i++) {
            if(array[i] % divider == 0){ 
                count--;
                accumulator[count] = array[i];
            }
        }

        return accumulator;
    }


    public static void bubbleSort(int[] array){
        /* implementation of bubblesort as understood from wikipedia:
         * https://nl.wikipedia.org/wiki/Bubblesort
         */
        int endPoint = array.length;
        //The endpoint keeps shifting left as large numbers bubble 'up'
        while(endPoint > 1) {
            for(int i = 0; i < endPoint - 1; i++) {
                //if left value is greater than right value, swap the two values
                if(array[i] > array[i + 1]){
                    swap(array, i, i + 1);
                }
            }
            endPoint--;
        }
    }


    public static void swap(int[] array, int posA, int posB) {
        int store = array[posA];
        array[posA] = array[posB];
        array[posB] = store;
    }


    public static int[] getNLowest(int[] array, int n) {
        /*get the n lowest numbers out of an array, in order of size 
         *assumes that n < array.length otherwise WILL crash
         *This is essentially a sorting algorithm probably also O=n^2
         */

        int[] lowestArray = new int[n]; //store lowest values
        
        for(int i = 0; i < lowestArray.length; i++){
            //set all elements of lowestArray to a relatively high value
            //enables lowest comparison otherwise blocked by 0s (this is kind of dirty)
            lowestArray[i] = 999;
        }

        //iterate through array and for each element check against lowestArray
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < n; j++){
                if(lowestArray[j] >= array[i]){
                    shove(lowestArray, j);
                    lowestArray[j] = array[i];
                    break;
                }
            }
        }

        return lowestArray;
    }


    public static void shove(int[] array, int pos){
        /*shift all elements of the array right one position from pos
         *the final element will be pushed out of the array
         */
        int end = array.length - 1;
        while(end > pos && end > 0){
            array[end] = array[end - 1];
            end--;
        }
    }
}
