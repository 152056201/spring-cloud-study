package com.yh.cloud.consumer.controller;

import com.yh.cloud.consumer.lb.LoadBalancer;
import com.yh.commons.entities.CommResult;
import com.yh.commons.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    //public static final String PAYMENT_ADDRESS = "http://localhost:8001";
    public static final String PAYMENT_ADDRESS = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/add")
    public CommResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_ADDRESS + "/payment/add", payment, CommResult.class);
        //return new CommResult(200,"添加成功");
    }

    @GetMapping("/consumer/payment/find/{id}")
    public CommResult getPayment(@PathVariable("id") Long id) {
        log.info("*******");
        return restTemplate.getForObject(PAYMENT_ADDRESS + "/payment/find/" + id, CommResult.class);
        //return new CommResult(200,"查询成功");
    }

    @GetMapping("/consumer/payment/forentity/{id}")
    public CommResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommResult> forEntity = restTemplate.getForEntity(PAYMENT_ADDRESS + "/payment/find/" + id, CommResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommResult<Payment>(400, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String balance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
