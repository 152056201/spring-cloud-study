package com.yh.hystrix.payment.controller;

import com.yh.hystrix.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Value(value = "${server.port}")
    private String serverPort;
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/hystrix/payment/ok/{id}")
    public String paymentSuccess(@PathVariable("id") Long id) {
        log.info("paymentService.hystrixSuccess(id)=" + paymentService.hystrixSuccess(id));
        return paymentService.hystrixSuccess(id);
    }

    @GetMapping("/hystrix/payment/fail/{id}")
    public String paymentFail(@PathVariable("id") Long id) {
        log.info("paymentService.hystrixFail(id)=" + paymentService.hystrixFail(id));
        return paymentService.hystrixFail(id);
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        String s = paymentService.paymentCircuitBreaker(id);
        log.info("***********s=" + s);
        return s;
    }
}
