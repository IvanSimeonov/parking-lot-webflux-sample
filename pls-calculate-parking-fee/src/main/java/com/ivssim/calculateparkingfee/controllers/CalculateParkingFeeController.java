package com.ivssim.calculateparkingfee.controllers;

import com.ivssim.calculateparkingfee.models.Vehicle;
import com.ivssim.calculateparkingfee.services.CalculateParkingFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class CalculateParkingFeeController {
    private final static String DEFAULT_URL = "http://pls-vehicle-service";
    private final static String FIND_CAR_BY_ID_URL = "/vehicles/{id}";
    private final CalculateParkingFeeService calculateParkingFeeService;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    public CalculateParkingFeeController(CalculateParkingFeeService calculateParkingFeeService) {
        this.calculateParkingFeeService = calculateParkingFeeService;
    }

    @GetMapping("/calculate-fee-costs/{id}")
    public Mono<Double> CalculateFeeCosts(@PathVariable("id") long id) {
        Mono<Vehicle> vehicleMono = webClientBuilder.build().get().uri(DEFAULT_URL + FIND_CAR_BY_ID_URL, id).retrieve().bodyToMono(Vehicle.class);
        return calculateParkingFeeService.calculateFee(vehicleMono);
    }


}
