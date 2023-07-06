package com.UDPServer.UDP;

import org.springframework.stereotype.Service;

import java.io.*;
import java.net.*;

@Service
public class TCPServer {
    public static void start() {
        int serverPort = 8083;
        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(serverPort);
                System.out.println("TCP server is listening...");

                Socket clientSocket = serverSocket.accept();
                System.out.println("TCP client connected: " + clientSocket.getInetAddress());

                InputStream in = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String message = reader.readLine();
                System.out.println("TCP client message: " + message);

                OutputStream out = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello, TCP client!");

                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

