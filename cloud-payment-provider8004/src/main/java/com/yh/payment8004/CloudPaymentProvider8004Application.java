package com.yh.payment8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudPaymentProvider8004Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudPaymentProvider8004Application.class, args);
    }

}
