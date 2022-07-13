package com.ivssim.calculateparkingfee.controllers;

import com.ivssim.calculateparkingfee.services.CalculateParkingFeeService;
import com.ivssim.clients.notification.NotificationClient;
import com.ivssim.clients.notification.NotificationDTO;
import com.ivssim.clients.vehicle.VehicleClient;
import com.ivssim.clients.vehicle.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class CalculateParkingFeeController {
    private final static String DEFAULT_URL = "http://pls-notification-service";

    private final VehicleClient vehicleClient;
    private final NotificationClient notificationClient;
    private final CalculateParkingFeeService calculateParkingFeeService;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    public CalculateParkingFeeController(CalculateParkingFeeService calculateParkingFeeService, VehicleClient vehicleClient, NotificationClient notificationClient) {
        this.calculateParkingFeeService = calculateParkingFeeService;
        this.vehicleClient = vehicleClient;
        this.notificationClient = notificationClient;
    }

    @GetMapping("/calculate-fee-costs/{id}")
    public Mono<Double> CalculateFeeCosts(@PathVariable("id") long id) {
        Mono<VehicleDTO> vehicleMono = vehicleClient.getVehicleById(id);
        vehicleMono.subscribe(vehicleDTO -> {
            NotificationDTO notificationDTO = new NotificationDTO();
            notificationDTO.setMessage("Vehicle Calculation Fee Completed!");
            notificationDTO.setVehicleLicensePlate(vehicleDTO.getLicensePlate());
            notificationDTO.setVehicleId(vehicleDTO.getId());
            webClientBuilder.build().post().uri(DEFAULT_URL).body(Mono.just(notificationDTO), NotificationDTO.class).retrieve().bodyToMono(NotificationDTO.class);
        });

        return calculateParkingFeeService.calculateFee(vehicleMono);
    }


}
