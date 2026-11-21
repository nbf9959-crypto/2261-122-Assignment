package unit09.skills;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Implements a simple Hangman game.
 */
public class Hangman {
    /**
     * The state of the game.
     */
    public enum GuessResult {
        CORRECT,         // guess was correct
        INCORRECT,       // guess was incorrect
        ALREADY_GUESSED, // guess was a duplicate
        INVALID          // guess was invalid - game not in progress or other
    }

    /**
     * The state of the game.
     */
    public enum State {
        IN_PROGRESS, // game is still in progress
        WON,         // game is won
        LOST;        // game is lost
    }

    /**
     * The maximum number of misses before the game is lost.
     */
    private static final int MAX_MISSES = 6;

    /**
     * The secret phrase.
     */
    private final String secret;

    /**
     * Remaining, unguessed characters from the secret phrase.
     */
    private Set<Character> remaining;

    /**
     * Characters that have been guessed so far.
     */
    private Set<Character> guesses;

    /**
     * The current state of the game.
     */
    private State state;

    /**
     * The number of misses.
     */
    private int misses;
    
    /**
     * Makes a new hangman game with the specified secret phrase.
     * @param secret
     */
    public Hangman(String secret) {
        this.secret = secret;
        remaining = new TreeSet<>();
        for(char c : secret.toCharArray()) {
            // only alphabetic characters are considered secret - any 
            // whitespace, punctuation, numbers, or special characters will not
            // be concealed.
            if(Character.isAlphabetic(c)) {
                remaining.add(Character.toLowerCase(c));
            }
        }
        this.guesses = new HashSet<>();
        this.misses = 0;
        this.state = State.IN_PROGRESS;
    }

    /**
     * Attempts to make a guess if the game is still in progress. If the guess
     * is a duplicate or the game is over, the guess is ignored.
     * 
     * @param guess The character being guessed.
     * 
     * @return guess result
     */
    public GuessResult guess(char guess) {
        GuessResult guessResult = GuessResult.INVALID;
        if(state == State.IN_PROGRESS) {
            char lower = Character.toLowerCase(guess);
            if (guesses.contains(lower)) {
                guessResult = GuessResult.ALREADY_GUESSED;
            } else if(misses < MAX_MISSES) {
                guesses.add(lower);
                if (remaining.remove(lower)) {
                    guessResult = GuessResult.CORRECT;
                } else {
                    guessResult = GuessResult.INCORRECT;
                    misses++;
                }

                if(misses < MAX_MISSES && remaining.size() == 0) {
                    state = State.WON;
                } else if(misses >= MAX_MISSES) {
                    state = State.LOST;
                }
            }
        }
        return guessResult;
    }

    /**
     * Returns the number of guesses remaining.
     * 
     * @return The number of guesses remaining.
     */
    public int getGuessesRemaining() {
        return MAX_MISSES - misses;
    }

    /**
     * Returns the state of the game.
     * 
     * @return The state of the game; ongoing, won, or lost.
     */
    public State getState() {
        return state;
    }

    /**
     * Returns a hint, with all of the guessed characters filled in. Any
     * characters that have not been guessed will be '_'.
     * 
     * @return A hint.
     */
    public String getHint() {
        StringBuilder hint = new StringBuilder();
        for(char c : secret.toCharArray()) {
            if(remaining.contains(Character.toLowerCase(c))) {
                hint.append('_');
            } else {
                hint.append(c);
            }
        }
        return hint.toString();
    }

    /**
     * Returns a string representation of the guessed characters. Characters are
     * returned in sorted order with no separators.
     * 
     * For example, if the user has guessed 'e', 'a', and 't', this method would
     * return "aet". If the user has not guessed any characters, this method
     * returns an empty string.
     * 
     * @return A string representation of the guessed characters.
     */
    public String getGuesses() {
        StringBuilder builder = new StringBuilder();
        for(char c : guesses) {
            builder.append(c);
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getHint());
        builder.append("\n");
        for(char c : guesses) {
            builder.append(c);
            builder.append(" ");
        }
        builder.append("\n");
        builder.append("remaining: " + (MAX_MISSES - misses));
        return builder.toString();
    }

    /**
     * Allows the user to play hangman from the command line.
     * 
     * @param args The command line arguments. These are not used.
     */
    public static void main(String[] args) {
        String secret = "Cookie";
        Hangman hangman = new Hangman(secret);
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println(hangman);
        while(hangman.getState() == State.IN_PROGRESS) {
            System.out.print(">> ");
            char c = scanner.nextLine().charAt(0);
            hangman.guess(c);
            System.out.println(hangman);
        }
        scanner.close();
        if(hangman.getState() == State.WON) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("You lost. Too bad!");
        }
    }
}
