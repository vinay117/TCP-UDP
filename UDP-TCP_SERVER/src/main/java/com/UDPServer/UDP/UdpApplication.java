package com.UDPServer.UDP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class UdpApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdpApplication.class, args);
        //TCPServer.start();
        //UDPServer.start();
    }

}
