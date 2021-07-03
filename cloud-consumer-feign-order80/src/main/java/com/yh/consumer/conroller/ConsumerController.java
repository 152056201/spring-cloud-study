package com.yh.consumer.conroller;

import com.yh.commons.entities.CommResult;
import com.yh.commons.entities.Payment;
import com.yh.consumer.service.ConsumerFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConsumerController {
    @Autowired
    private ConsumerFeignService feignService;
    @GetMapping("/consumer/payment/find/{id}")
    public CommResult<Payment> findByFeign(@PathVariable("id") Long id){
        return feignService.find(id);
    }
}
