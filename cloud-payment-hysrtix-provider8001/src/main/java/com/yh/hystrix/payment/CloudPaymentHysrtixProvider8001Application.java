package com.yh.hystrix.payment;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CloudPaymentHysrtixProvider8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudPaymentHysrtixProvider8001Application.class, args);
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet metricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegister = new ServletRegistrationBean(metricsStreamServlet);
        servletRegister.setLoadOnStartup(1);
        servletRegister.addUrlMappings("/actuator/hystrix.stream");
        servletRegister.setName("HystrixMetricsStreamServlet");
        return servletRegister;
    }

}
