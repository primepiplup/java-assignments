package nl.sogyo.javaopdrachten;

import java.util.ArrayList;

public class GuessWord {
    
    private char[] wordToGuess;
    private char[] correctCharacters;
    private ArrayList<Character> incorrectCharacters;


    public GuessWord() {
        setWordToGuess();
        setGuessedLetters();
    }


    private void setWordToGuess() {
        String guessWord = getWordToGuess();
        wordToGuess = guessWord.toCharArray();
    }


    private String getWordToGuess() { 
        return "HANGMAN"; //default for now, may randomize?
    }


    private void setGuessedLetters() {
        correctCharacters = new char[wordToGuess.length];
        incorrectCharacters = new ArrayList<Character>();
    }


    public void printCorrectCharacters() {
        System.out.println("Current known word: ");
        for(int i = 0; i < correctCharacters.length; i++) {
            if(isNotSet(correctCharacters[i])) {
                System.out.print("_");
            } else {
                System.out.print(correctCharacters[i]);
            }
        }
        System.out.println();
    }


    private boolean isNotSet(char c) {
        return (c == '\u0000');
    }


    public void printIncorrectCharacters() {
        System.out.println("Incorrect guesses: ");
        for(int i = 0; i < incorrectCharacters.size(); i++) {
            System.out.print(incorrectCharacters.get(i) + " ");
        }
        System.out.println();
    }


    public boolean checkGuess(char guessedLetter) {
        boolean isCorrect = false;
        
        for(int i = 0; i < wordToGuess.length; i++) {
            if(wordToGuess[i] == guessedLetter) {
                isCorrect = true;
                setCorrectLetter(guessedLetter, i);
            }
        }

        if(!isCorrect) {
            incorrectCharacters.add(guessedLetter);
        }

        return isCorrect;
    }


    public boolean isCompleted() {
        for(int i = 0; i < correctCharacters.length; i++) {
            if(isNotSet(correctCharacters[i])) { return false; }
        }
        return true;
    }


    private void setCorrectLetter(char guessedLetter, int position) {
        correctCharacters[position] = guessedLetter;
    }
}
