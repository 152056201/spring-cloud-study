package com.yh.payment.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class CloudPaymentHysrtixDashboard9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudPaymentHysrtixDashboard9001Application.class, args);
    }

}
