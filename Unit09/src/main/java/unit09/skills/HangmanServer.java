package unit09.skills;

import unit09.skills.HTTP.*;
import java.util.function.Supplier;

public class HangmanServer {
    public static void main(String[] args) {
        Supplier<RequestHandler> handler = () -> new HangmanRequestHandler(); 
        HttpWebServer server = new HttpWebServer(8081, handler);

        server.start();
    }
}
