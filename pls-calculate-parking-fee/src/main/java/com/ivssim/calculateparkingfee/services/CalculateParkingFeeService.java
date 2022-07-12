package com.ivssim.calculateparkingfee.services;

import com.ivssim.calculateparkingfee.models.Vehicle;
import reactor.core.publisher.Mono;

public interface CalculateParkingFeeService {
    Mono<Double> calculateFee(Mono<Vehicle> vehicleMono);

}
