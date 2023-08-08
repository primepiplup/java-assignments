package nl.sogyo.javaopdrachten;

import java.util.Scanner;

public class UserManager {

    public static void askForUserRegistration() {
        Scanner userInput = new Scanner(System.in);
        String username = askForUsername(userInput); 
        System.out.println("Enter a password");
        String password = userInput.nextLine();
        try {
            registerUser(username, password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerUser(String username, String password) throws Exception {
        if(isValidPassword(password)){
            System.out.println("Registered user: " + username + ".");
        } else {
            throw new Exception("Horrible crash caused by incorrect password!");
        }
    }

    private static String askForUsername(Scanner userInput) {
        String username;
        do{ 
            System.out.println("Enter a username");
            username = userInput.nextLine();
        } while(!isValidUsername(username));
        return username;
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
