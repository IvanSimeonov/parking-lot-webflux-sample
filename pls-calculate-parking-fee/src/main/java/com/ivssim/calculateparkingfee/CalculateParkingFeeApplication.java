package com.ivssim.calculateparkingfee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableReactiveFeignClients(
        basePackages = "com.ivssim.clients"
)
public class CalculateParkingFeeApplication {
        public static void main(String[] args) {
            SpringApplication.run(CalculateParkingFeeApplication.class, args);
        }
}
