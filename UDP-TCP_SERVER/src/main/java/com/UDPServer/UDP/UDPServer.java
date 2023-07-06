package com.UDPServer.UDP;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@Service
public class UDPServer {
    public static void  start() {
        int serverPort = 8081;
        while (true) {
            try {
                DatagramSocket socket = new DatagramSocket(serverPort);
                System.out.println("UDP server is listening...");

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("UDP client message: " + message);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String response = "Hello, UDP client!";
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
