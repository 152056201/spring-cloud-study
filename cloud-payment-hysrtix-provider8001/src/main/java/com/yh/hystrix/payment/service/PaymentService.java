package com.yh.hystrix.payment.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.micrometer.core.instrument.util.TimeUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String hystrixSuccess(Long id) {
        return Thread.currentThread().getName() + "hystrixSuccess" + id + "hello";
    }


    @HystrixCommand(fallbackMethod = "hystrixFailHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String hystrixFail(Long id) {
        try {
            TimeUnit.SECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + "hystrixFail" + id + "goodbey";
    }

    public String hystrixFailHandler(Long id) {
        return Thread.currentThread().getName() + "hystrixFailHandler" + id + "O(∩_∩)O哈哈~";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率
    })
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "流水号=" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Long id) {
        return "id不能为负数，请稍后再试";
    }
}
