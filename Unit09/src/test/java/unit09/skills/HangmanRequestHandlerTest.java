package unit09.skills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

import unit09.skills.HTTP.*;;

class HangmanRequestHandlerTest {
    private static final String TEST_SECRET = "hello";

    // Test helper methods
    private static HttpRequest get(String uri) {
        return new HttpRequest(HttpRequest.Method.GET, uri, Map.of(), null);
    }

    private static HttpRequest postGuess(String body) {
        return new HttpRequest(HttpRequest.Method.POST, "/guess", Map.of(), body);
    }

    @Test
    void getStateReturnsInProgressForNewGame() {
        // setup
        HangmanRequestHandler handler = new HangmanRequestHandler(TEST_SECRET);
        String stateRoute = "/state";
        String expectedState = "IN_PROGRESS";

        // invoke
        String response = handler.handleRequest(get(stateRoute));

        // analyze
        assertEquals(expectedState, response);
    }

    @Test
    void getHintReturnsMaskedSecretInitially() {
        // setup
        HangmanRequestHandler handler = new HangmanRequestHandler(TEST_SECRET);
        String hintRoute = "/hint";
        String expectedHint = "_____";

        // invoke
        String response = handler.handleRequest(get(hintRoute));

        // analyze
        assertEquals(expectedHint, response);
    }

    @Test
    void getGuessesRemainingStartsAtSix() {
        // setup
        HangmanRequestHandler handler = new HangmanRequestHandler(TEST_SECRET);
        String guessesRemainingRoute = "/guessesremaining";
        String expectedGuessesRemaining = "6";

        // invoke
        String response = handler.handleRequest(get(guessesRemainingRoute));

        // analyze
        assertEquals(expectedGuessesRemaining, response);
    }

    @Test
    void postGuessReturnsCorrectAndRevealsLetter() {
        // setup
        HangmanRequestHandler handler = new HangmanRequestHandler(TEST_SECRET);
        String guessedLetter = "e";
        String hintRoute = "/hint";
        String expectedGuessResult = "CORRECT";
        String expectedHint = "_e___";

        // invoke
        String guessResult = handler.handleRequest(postGuess(guessedLetter));
        String hint = handler.handleRequest(get(hintRoute));

        // analyze
        assertEquals(expectedGuessResult, guessResult);
        assertEquals(expectedHint, hint);
    }

    @Test
    void postGuessReturnsAlreadyGuessedForDuplicateLetter() {
        // setup
        HangmanRequestHandler handler = new HangmanRequestHandler(TEST_SECRET);
        String duplicateGuess = "e";
        String expectedSecondGuessResult = "ALREADY_GUESSED";

        // invoke
        handler.handleRequest(postGuess(duplicateGuess));
        String secondResult = handler.handleRequest(postGuess(duplicateGuess));

        // analyze
        assertEquals(expectedSecondGuessResult, secondResult);
    }

    @Test
    void postGuessReturnsInvalidForNullOrWrongLengthBody() {
        // setup
        HangmanRequestHandler handler = new HangmanRequestHandler(TEST_SECRET);
        String invalidLengthGuess = "ab";
        String expectedInvalidResult = "INVALID";

        // invoke
        String nullBodyResult = handler.handleRequest(postGuess(null));
        String twoCharBodyResult = handler.handleRequest(postGuess(invalidLengthGuess));

        // analyze
        assertEquals(expectedInvalidResult, nullBodyResult);
        assertEquals(expectedInvalidResult, twoCharBodyResult);
    }

    @Test
    void guessingAllUniqueSecretLettersTransitionsToWon() {
        // setup
        HangmanRequestHandler handler = new HangmanRequestHandler(TEST_SECRET);
        String firstGuess = "h";
        String secondGuess = "e";
        String thirdGuess = "l";
        String fourthGuess = "o";
        String stateRoute = "/state";
        String expectedState = "WON";

        // invoke
        handler.handleRequest(postGuess(firstGuess));
        handler.handleRequest(postGuess(secondGuess));
        handler.handleRequest(postGuess(thirdGuess));
        handler.handleRequest(postGuess(fourthGuess));

        String state = handler.handleRequest(get(stateRoute));

        // analyze
        assertEquals(expectedState, state);
    }

    @Test
    void sixIncorrectGuessesTransitionsToLost() {
        // setup
        HangmanRequestHandler handler = new HangmanRequestHandler(TEST_SECRET);
        String firstGuess = "a";
        String secondGuess = "b";
        String thirdGuess = "c";
        String fourthGuess = "d";
        String fifthGuess = "f";
        String sixthGuess = "g";
        String stateRoute = "/state";
        String guessesRemainingRoute = "/guessesremaining";
        String expectedState = "LOST";
        String expectedGuessesRemaining = "0";

        // invoke
        handler.handleRequest(postGuess(firstGuess));
        handler.handleRequest(postGuess(secondGuess));
        handler.handleRequest(postGuess(thirdGuess));
        handler.handleRequest(postGuess(fourthGuess));
        handler.handleRequest(postGuess(fifthGuess));
        handler.handleRequest(postGuess(sixthGuess));

        String state = handler.handleRequest(get(stateRoute));
        String guessesRemaining = handler.handleRequest(get(guessesRemainingRoute));

        // analyze
        assertEquals(expectedState, state);
        assertEquals(expectedGuessesRemaining, guessesRemaining);
    }

    @Test
    void unknownRouteReturnsNull() {
        // setup
        HangmanRequestHandler handler = new HangmanRequestHandler(TEST_SECRET);
        String unknownRoute = "/does-not-exist";

        // invoke
        String response = handler.handleRequest(get(unknownRoute));

        // analyze
        assertNull(response);
    }

    @Test
    void getGuessesReturnsEmptyStringForNewGame() {
        // setup
        HangmanRequestHandler handler = new HangmanRequestHandler(TEST_SECRET);
        String guessesRoute = "/guesses";
        String expectedGuesses = "";

        // invoke
        String response = handler.handleRequest(get(guessesRoute));

        // analyze
        assertEquals(expectedGuesses, response);
    }

    @Test
    void getGuessesReturnsGuessedLettersAfterGuessing() {
        // setup
        HangmanRequestHandler handler = new HangmanRequestHandler(TEST_SECRET);
        String firstGuess = "a";
        String secondGuess = "e";
        String guessesRoute = "/guesses";
        int expectedLength = 2;

        // invoke
        handler.handleRequest(postGuess(firstGuess));
        handler.handleRequest(postGuess(secondGuess));
        String response = handler.handleRequest(get(guessesRoute));

        // analyze
        // getGuesses returns letters in HashSet iteration order (not sorted),
        // so check that both letters are present rather than asserting a fixed order.
        assertEquals(expectedLength, response.length());
        assertTrue(response.contains(firstGuess));
        assertTrue(response.contains(secondGuess));
    }
}
