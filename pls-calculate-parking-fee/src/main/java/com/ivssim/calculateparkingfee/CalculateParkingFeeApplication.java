package com.ivssim.calculateparkingfee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CalculateParkingFeeApplication {
        public static void main(String[] args) {
            SpringApplication.run(CalculateParkingFeeApplication.class, args);
        }
}
