package unit08.skills;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

public class Client {

    public static void sendMessage(String message, PrintWriter out) {
        out.println(message);
        out.flush(); 
    }

    public static void waitOnProtocolMessage(String message, Scanner in) {
        String received = ""; 

        while(!message.equals(received)) {
            received = in.nextLine(); 
            System.out.println(received);
        }
    }

    public static void sendFile(String file, Scanner in, PrintWriter out) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Stream<String> lines = reader.lines();

            lines.forEach(line -> {
                sendMessage(line, out); 
                waitOnProtocolMessage("RCVD", in);
            });

            sendMessage("DONE", out); 
            waitOnProtocolMessage("OK", in);
        } catch (Exception e) {

        }
    }
    
    public static void main(String[] args) throws Exception {
        Socket connection = new Socket("localhost", 54321);

        Scanner in = new Scanner(connection.getInputStream());
        PrintWriter out = new PrintWriter(connection.getOutputStream()); 
        String filename = "data/alice.txt"; 

        sendMessage("HELLO", out); 
        waitOnProtocolMessage("HI", in);

        sendMessage("SEND", out);
        waitOnProtocolMessage("START", in);

        sendFile(filename, in, out); 
        
        sendMessage("BYE", out); 
        waitOnProtocolMessage("ACK", in);
    }
}
