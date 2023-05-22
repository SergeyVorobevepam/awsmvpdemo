package com.vorobev.generalservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/api/v1/generalservice")
public class HealthController {

    @GetMapping("/health")
    public String helloWorld() {
        String message = "Healthy! ";

        try {
            InetAddress ip = InetAddress.getLocalHost();
            message += " The current host: " + ip;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return message;
    }
}
