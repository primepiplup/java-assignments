package nl.sogyo.javaopdrachten;

import java.util.GregorianCalendar;

public class Quote {
    static String[][] quotes = {
        {"galileo", "eppur si muove"},
        {"archimedes", "eureka!"},
        {"erasmus", "in regione caecorum rex est luscus"},
        {"socrates", "I know nothing except the fact of my ignorance"},
        {"rené descartes", "cogito, ergo sum"},
        {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}
    };

    public static void main(String[] args) {
        int dayIndex = getIndexForDay();
        printQuoteWithNameAtIndex(dayIndex);
    }


    public static int getIndexForDay() {
        int dayIndex = getDayNumber() % 6;
        return dayIndex; 
    }


    public static int getDayNumber() {
        GregorianCalendar rightNow = new GregorianCalendar();
        return rightNow.get(GregorianCalendar.DAY_OF_YEAR);
    }


    public static void printQuoteWithNameAtIndex(int index) {
        printQuoteAtIndex(index);
        System.out.print(" --- ");
        printNameAtIndex(index);
        System.out.println();
    }


    public static void printQuoteAtIndex(int index) {
        String quote = getQuoteAtIndex(index);
        quote = capitalizeFirstLetter(quote);
        quote = ensureEndingPunctuation(quote);
        quote = surroundWithQuotes(quote);
        System.out.print(quote);
    }


    public static void printNameAtIndex(int index) {
        String name = getNameAtIndex(index);
        name = capitalizeNames(name);
        System.out.print(name);
    }


    private static String getQuoteAtIndex(int index) {
        return quotes[index][1];
    }


    private static String getNameAtIndex(int index) {
        return quotes[index][0];
    }


    public static String surroundWithQuotes(String quote) {
        return '"' + quote + '"';
    }


    public static String capitalizeNames(String name) {
        String[] names = name.split(" ");
        for(int i = 0; i < names.length; i++) {
            names[i] = capitalizeFirstLetter(names[i]);
        }
        name = arrayToSpaceSeparatedString(names);
        return name;
    }


    public static String arrayToSpaceSeparatedString(String[] stringArray) {
        StringBuilder accumulator = new StringBuilder();
        for(int i = 0; i < stringArray.length; i++) {
            accumulator.append(stringArray[i]);
            if(i < stringArray.length - 1) { 
                accumulator.append(' ');
            }
        }
        String returnString = accumulator.toString();
        return returnString;
    }


    public static String capitalizeFirstLetter(String quote) {
        String replacedQuote = quote; //Maybe split in two?
        if(notCapitalized(quote)) {
            replacedQuote = setFirstUppercase(replacedQuote);
        }
        return replacedQuote;
    }


    public static String ensureEndingPunctuation(String quote) {
        String replacedQuote = quote;
        if(notEndingOnFullStop(quote)) {
            replacedQuote = appendFullStop(replacedQuote);
        }
        return replacedQuote;
    }


    public static boolean notCapitalized(String quote) {
        char firstLetter = quote.charAt(0);
        return !Character.isUpperCase(firstLetter);
    }


    public static boolean notEndingOnFullStop(String quote) {
        char lastLetter = quote.charAt(quote.length() - 1);
        return Character.isLetter(lastLetter);
    }


    public static String setFirstUppercase(String quote) {
        char letter = quote.charAt(0);
        letter = Character.toUpperCase(letter);
        String replacedQuote = letter + quote.substring(1);
        return replacedQuote;
    }


    public static String appendFullStop(String quote) {
        String replacedQuote = quote + '.';
        return replacedQuote;
    }
}