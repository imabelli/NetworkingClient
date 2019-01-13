package client;
import java.util.*;
import java.net.*;
import java.io.*;

public class LearningSocket {
    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 8000;

        try{
            Socket socket = new Socket(hostname, port);
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("GET /abc");
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

