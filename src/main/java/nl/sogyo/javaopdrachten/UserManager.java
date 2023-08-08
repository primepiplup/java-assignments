package nl.sogyo.javaopdrachten;

import java.util.Scanner;

public class UserManager {

    public static void askForUserRegistration() {
        Scanner userInput = new Scanner(System.in);
        String username = askForUsername(userInput); 
        String password = askForPassword(userInput);
        registerUser(username, password);
    }

    public static void registerUser(String username, String password) {
        System.out.println("Registered user: " + username + ".");
    }

    private static String askForUsername(Scanner userInput) {
        System.out.println("Enter a username");
        String username = userInput.nextLine();
        while(!isValidUsername(username)) { 
            System.out.println("Invalid username, please enter a different username");
            username = userInput.nextLine();
        }
        return username;
    }

    private static String askForPassword(Scanner userInput) {
        System.out.println("Enter a password");
        String password = userInput.nextLine();
        while(!isValidPassword(password)) {
            System.out.println("Invalid password, please enter a different password");
            password = userInput.nextLine();
        }
        return password;
    }

    public static Boolean isValidUsername(String username) {
        if(username.isBlank()) {
            return false;
        } else if(username.contains(" ")) {
            return false;
        }
        return true;
    }

    public static Boolean isValidPassword(String password) {
        char[] passwordArray = password.toCharArray();
        if(!containsCapital(passwordArray)) {
            return false;
        } else if(!containsLowerCase(passwordArray)) {
            return false;
        } else if(!containsNumber(passwordArray)) {
            return false;
        } else {
            return true;
        }
    }

    private static Boolean containsCapital(char[] password) {
        for(char c : password) {
            if(Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static Boolean containsLowerCase(char[] password) {
        for(char c : password) {
            if(Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static Boolean containsNumber(char[] password) {
        for(char c : password) {
            if(Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
