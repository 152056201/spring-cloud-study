package com.yh.payment8004.controller;

import com.yh.commons.entities.CommResult;
import com.yh.commons.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String zookeeper() {
        return "zookeeper" + serverPort + "\n" + UUID.randomUUID().toString();
    }
}
