package com.yh.order.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = OrderFallBackService.class)
public interface OrderService {
    @GetMapping("/hystrix/payment/ok/{id}")
    public String paymentSuccess(@PathVariable("id") Long id);

    @GetMapping("/hystrix/payment/fail/{id}")
    public String paymentFail(@PathVariable("id") Long id);

}
