package com.yh.consumer.service;

import com.yh.commons.entities.CommResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface ConsumerFeignService {
    @GetMapping(value = "/payment/find/{id}")
    public CommResult find(@PathVariable("id") Long id);
}
