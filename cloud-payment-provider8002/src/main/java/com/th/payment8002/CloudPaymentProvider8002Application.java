package com.th.payment8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudPaymentProvider8002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudPaymentProvider8002Application.class, args);
    }

}
