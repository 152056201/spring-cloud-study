package com.yh.consumerconsul.controller;

import com.yh.commons.entities.CommResult;
import com.yh.commons.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    //public static final String PAYMENT_ADDRESS = "http://localhost:8001";
    public static final String PAYMENT_ADDRESS = "http://cloud-payment-service06";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul")
    public String consumer() {
        return restTemplate.getForObject(PAYMENT_ADDRESS + "/payment/consul", String.class);
    }
}
