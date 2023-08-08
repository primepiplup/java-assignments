package nl.sogyo.javaopdrachten;

public class UserManager {

    public static void registerUser(String username, String password) {
        if(isValidPassword(password)){
            System.out.println("Registered user: " + username);
        } else {
            //Next part of assignment
        }
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
