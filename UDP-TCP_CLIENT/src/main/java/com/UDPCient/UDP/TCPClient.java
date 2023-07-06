package com.UDPCient.UDP;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.*;
@Service
public class TCPClient {
    public static void start() {
        String serverIP = "127.0.0.1";
        int serverPort = 8083;

        try {
            Socket socket = new Socket(serverIP, serverPort);
            long startTime = System.nanoTime();
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello, TCP server!");

            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String response = reader.readLine();

            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            double seconds = elapsedTime / 1000000000.0;
            System.out.println("Response time: " + seconds + " seconds");
            System.out.println("TCP server response: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

