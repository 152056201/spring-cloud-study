package com.yh.order.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yh.order.hystrix.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_fallback")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /*@HystrixCommand*/
    @GetMapping("/consumer/hystrix/payment/ok/{id}")
    public String paymentSuccess(@PathVariable("id") Long id) {
        //int a = 10 / 0;
        return orderService.paymentSuccess(id);
    }

    @HystrixCommand(fallbackMethod = "paymentFailFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    @GetMapping("/consumer/hystrix/payment/fail/{id}")
    public String paymentFail(@PathVariable("id") Long id) {

        return orderService.paymentFail(id);
    }

    public String paymentFailFallBack(@PathVariable("id") Long id) {
        return "消费者fallback";
    }

    public String global_fallback() {
        return "服务出现故障，调用全局fallback方法";
    }
}
