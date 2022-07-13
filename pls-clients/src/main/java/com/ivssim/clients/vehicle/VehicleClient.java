package com.ivssim.clients.vehicle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "vehicle", url = "http://pls-vehicle-service")
public interface VehicleClient {

    @GetMapping("/vehicles/{id}")
    Mono<VehicleDTO> getVehicleById(@PathVariable("id") Long id);

}
