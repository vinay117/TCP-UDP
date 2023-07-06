package com.UDPCient.UDP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.*;

@SpringBootApplication
public class UdpApplication {

    public static void main(String[] args) {

        SpringApplication.run(UdpApplication.class, args);
          //TCPClient.start();

        //UDPClient.start();
    }

}
