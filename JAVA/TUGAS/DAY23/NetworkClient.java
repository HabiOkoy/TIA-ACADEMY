/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAY_21.Tugas;

/**
 *
 * @author Xiao You
 */
import java.io.*;
import java.net.*;

public class NetworkClient {
    public static void main(String[] args) {
        String ipAddress = args.length > 0 ? args[0] : "localhost";
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 8000;

        try {
            Socket socket = new Socket(ipAddress, port);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("Connected to server on " + ipAddress + ":" + port);

            String message = "Hello from client!";
            writer.write(message);
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println("Server response: " + response);

            socket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
