package com.yh.payment8006.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Value(value = "${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String consul() {
        return "Spring Cloud Consul serverPort=" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
