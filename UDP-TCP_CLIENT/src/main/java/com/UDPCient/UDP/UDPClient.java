package com.UDPCient.UDP;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@Service
public class UDPClient {
    public static void start() {
        String serverIP = "127.0.0.1";
        int serverPort = 8081;

        try {
            DatagramSocket socket = new DatagramSocket();

            String message = "Hello, UDP server!";
            byte[] sendData = message.getBytes();
            InetAddress serverAddress = InetAddress.getByName(serverIP);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);
            long startTime = System.nanoTime();

            System.out.println("Message sent");
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());

            long endTime = System.nanoTime();
            long responseTime = endTime - startTime;
            double seconds = responseTime / 1000000000.0;
            System.out.println("Response time: " + seconds + " seconds");

            System.out.println("UDP server response: " + response);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
