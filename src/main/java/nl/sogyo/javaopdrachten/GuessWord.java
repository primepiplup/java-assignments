package nl.sogyo.javaopdrachten;

public class GuessWord {
    
    private String wordToGuess;
    
    public GuessWord() {
        setWordToGuess();
    }

    public void setWordToGuess() {
        wordToGuess = "HANGMAN";
    }

    public void printWordToGuess() {
        System.out.println(wordToGuess);
    }

    // private static char[] getUniqueLetters(){
        
    // }
}
