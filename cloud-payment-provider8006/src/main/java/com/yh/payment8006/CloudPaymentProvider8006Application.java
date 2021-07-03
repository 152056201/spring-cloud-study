package com.yh.payment8006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudPaymentProvider8006Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudPaymentProvider8006Application.class, args);
    }

}
