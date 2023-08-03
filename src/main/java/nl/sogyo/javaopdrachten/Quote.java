package nl.sogyo.javaopdrachten;

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
        for(int i = 0; i < quotes.length; i++) {
            printQuoteAtIndex(i);
            System.out.println();
        }
    }


    public static void printQuoteAtIndex(int index) {
        String quote = getQuoteAtIndex(index);
        quote = fixCapitalAndPunctuation(quote);
        quote = surroundWithQuotes(quote);
        System.out.print(quote);
    }


    private static String getQuoteAtIndex(int index) {
        return quotes[index][1];
    }


    public static String surroundWithQuotes(String quote) {
        return '"' + quote + '"';
    }


    public static String fixCapitalAndPunctuation(String quote) {
        String replacedQuote = quote;
        if(notCapitalized(quote)) {
            replacedQuote = setFirstUppercase(replacedQuote);
        }
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