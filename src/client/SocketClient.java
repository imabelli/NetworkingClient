package client;
import java.util.*;
import java.net.*;
import java.io.*;

public class SocketClient {
    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 900;

        //String hostname = "google.com";
        //int port = 80;
        //server input output stream are binary
        try{
            Socket socket = new Socket(hostname, port);
            OutputStream output = socket.getOutputStream(); //what you send
            PrintWriter writer = new PrintWriter(output, true); //converts text to
            writer.println("GET /");
            writer.println();
            writer.flush();

            InputStream input = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnknownHostException ex) {
                System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
                System.out.println("I/O error: " + ex.getMessage());
        }
    }
}

