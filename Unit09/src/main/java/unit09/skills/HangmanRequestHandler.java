package unit09.skills;

import unit09.skills.HTTP.RequestHandler;
import unit09.skills.HTTP.HttpRequest;

import java.util.Random;

public class HangmanRequestHandler implements RequestHandler {

    private Hangman instance; 

    public HangmanRequestHandler(String term) {
        instance = new Hangman(term);
    }

    public HangmanRequestHandler() {
        String[] defaults = {"Boeing", "Cookie", "UNIX", "CFM-56A", "MiG-31M"};
        Random generator = new Random(); 
        
        instance = new Hangman(defaults[generator.nextInt(defaults.length)]);
    }

    @Override 
    public String handleRequest(HttpRequest request) {
        String endpoint = request.getUri(); 

        if(request.getMethod().toString().equals("GET")) {
            if(endpoint.contains("/state")) {
                return this.instance.getState().toString(); 
            }

            if(endpoint.contains("/hint")) {
                return this.instance.getHint(); 
            }

            if(endpoint.contains("/guessesremaining")) {
                return String.valueOf(this.instance.getGuessesRemaining()); 
            }

            if(endpoint.contains("/guesses")) {
                return this.instance.getGuesses(); 
            }
        }

        if(request.getMethod().toString().equals("POST")) {
            if(endpoint.contains("/guess")) {
                if (request.getBody().length() < 2) {
                    char letter = request.getBody().charAt(0);

                    return instance.guess(letter).toString();
                } else {
                    return "The guess is invalid!";
                }
            }
        }

        return null;
    }; 
}
