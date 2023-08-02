package nl.sogyo.javaopdrachten;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Input a year: ");
        int year = input.nextInt();
        
        if(isLeapYear(year)){    
            System.out.println("That year is a leap year!");
        } else {
            System.out.println("That year is not a leap year!");
        }
        //Scanner apparently needs to be closed - resource leak warning
        input.close();
    }

    public static boolean isLeapYear(int year) {
        if(year % 4 == 0) {
            if(year % 100 == 0 && year % 400 != 0) { /*no leapyear*/ }
            else { return true; }
        } 
        return false;
    }
}
