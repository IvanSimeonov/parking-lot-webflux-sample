package com.ivssim.calculateparkingfee.services;

import com.ivssim.clients.vehicle.VehicleDTO;
import reactor.core.publisher.Mono;

public interface CalculateParkingFeeService {
    Mono<Double> calculateFee(Mono<VehicleDTO> vehicleMono);

}
