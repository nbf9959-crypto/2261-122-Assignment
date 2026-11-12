package unit08.skills;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.stream.Stream;

public class Server {

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

    public static int receiveFile(Scanner in, PrintWriter out) {
        String data = "";
        int lines = 0; 

        data = in.nextLine(); 
        while(!data.equals("DONE")) {
            System.out.println(data); 
            sendMessage("RCVD", out);

            lines++;
            data = in.nextLine(); 
        }

        sendMessage("OK", out);

        return lines; 
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(54321);

        while(true) {
            Socket connection = server.accept(); 

            Scanner in = new Scanner(connection.getInputStream()); 
            PrintWriter out = new PrintWriter(connection.getOutputStream()); 

            waitOnProtocolMessage("HELLO", in);
            sendMessage("HI", out);

            waitOnProtocolMessage("SEND", in);
            sendMessage("START", out);
                
            System.out.println(String.format("\n\n>> Received %s lines of data <<\n\n", receiveFile(in, out)));

            waitOnProtocolMessage("BYE", in);
            sendMessage("ACK", out);
        }
    }
}
