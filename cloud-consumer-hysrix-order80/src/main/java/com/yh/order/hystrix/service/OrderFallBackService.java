package com.yh.order.hystrix.service;

import org.springframework.stereotype.Component;

@Component
public class OrderFallBackService implements OrderService {
    @Override
    public String paymentSuccess(Long id) {
        return "fallback --- paymentSuccess";
    }

    @Override
    public String paymentFail(Long id) {
        return "fallback -- paymentFail";
    }
}
