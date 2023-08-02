package nl.sogyo.javaopdrachten;

import java.util.random.*;

public class Lists {
    public static void main(String[] args) {
        //initialize random number generator
        RandomGenerator random = RandomGenerator.getDefault();
        //random list will be initialized with given length
        int length = 10;
        int[] randomList = new int[length];
        for(int i = 0; i < length; i++) {
            //populate list with random numbers
            randomList[i] = random.nextInt(0, 100);
            System.out.println(randomList[i]);
        }
        //print greatest array value
        System.out.print("The highest number is: ");
        System.out.println(getMax(randomList));
    }

    public static int getMax(int[] array){
        int max = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > max) {max = array[i];}
        }
        return max;
    }
}
