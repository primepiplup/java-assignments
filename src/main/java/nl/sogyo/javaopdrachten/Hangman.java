package nl.sogyo.javaopdrachten;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        int guessesLeft = 10;
        GuessWord guessWord = new GuessWord();
        Scanner standardIn = new Scanner(System.in);
        boolean hasWon = false;

        while(guessesLeft > 0 && !hasWon) {
            System.out.printf("You have %d guesses left!\n", guessesLeft);
            guessWord.printCorrectCharacters();
            guessWord.printIncorrectCharacters();
            char guess = getGuess(standardIn);
            boolean isCorrect = guessWord.checkGuess(guess);
            if(!isCorrect) { guessesLeft--; }
            if(guessWord.isCompleted()) { hasWon = true; }
        }

        if(hasWon) {
            guessWord.printCorrectCharacters();
            System.out.println("Congratulations! You got the word!");
        } else {
            System.out.println("Unfortunately you ran out of guesses...");
            System.out.println("Better luck next time!");
        }
    }    


    public static char getGuess(Scanner inputStream) {
        String inputLine = inputStream.nextLine();
        char inputCharacter = inputLine.toCharArray()[0];
        while(notSingleCharacter(inputLine) || !Character.isLetter(inputCharacter)) {
            System.out.println("Please input a single letter for a guess.");
            inputLine = inputStream.nextLine();
            inputCharacter = inputLine.toCharArray()[0];
        }
        inputCharacter = Character.toUpperCase(inputCharacter);
        return inputCharacter;
    }


    public static boolean notSingleCharacter(String input) {
        return (input.length() != 1);
    }
}