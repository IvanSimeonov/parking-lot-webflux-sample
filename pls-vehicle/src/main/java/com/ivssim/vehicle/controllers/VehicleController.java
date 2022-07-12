package com.ivssim.vehicle.controllers;

import com.ivssim.vehicle.domains.VehicleDTO;
import com.ivssim.vehicle.enums.EuropeanEmissionStandard;
import com.ivssim.vehicle.enums.FuelType;
import com.ivssim.vehicle.enums.VehicleType;
import com.ivssim.vehicle.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Date;

@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Mono<VehicleDTO>> getVehicleById(@PathVariable("id") Long id) {
        Mono<VehicleDTO> vehicle = this.vehicleService.findVehicleById(id);
        return ResponseEntity.ok().body(vehicle);
    }

    @GetMapping("/vehicles/licensePlate")
    public ResponseEntity<Mono<VehicleDTO>> getVehicleByLicensePlate(@RequestParam("licensePlate") String licensePlate) {
        Mono<VehicleDTO> vehicle = this.vehicleService.findVehicleByLicensePlate(licensePlate);
        return ResponseEntity.ok().body(vehicle);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<Flux<VehicleDTO>> getAllVehicles() {
        Flux<VehicleDTO> vehicles = this.vehicleService.findAllVehicles();
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/vehicles/brand")
    public ResponseEntity<Flux<VehicleDTO>> getAllVehiclesByBrand(@RequestParam("brand") String brand) {
        Flux<VehicleDTO> vehicles = this.vehicleService.findVehiclesByBrand(brand);
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/vehicles/vehicleType")
    public ResponseEntity<Flux<VehicleDTO>> getAllVehiclesByVehicleType(@RequestParam("vehicleType") String vehicleType) {
        Flux<VehicleDTO> vehicles = this.vehicleService.findVehiclesByVehicleType(VehicleType.valueOf(vehicleType));
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/vehicles/fuelType")
    public ResponseEntity<Flux<VehicleDTO>> getAllVehiclesByFuelType(@RequestParam("fuelType") String fuelType) {
        Flux<VehicleDTO> vehicles = this.vehicleService.findVehiclesByFuelType(FuelType.valueOf(fuelType));
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/vehicles/europeanEmissionStandard")
    public ResponseEntity<Flux<VehicleDTO>> getAllVehiclesByEuropeanEmissionStandard(@RequestParam("europeanEmissionStandard") String europeanEmissionStandard) {
        Flux<VehicleDTO> vehicles = this.vehicleService.findVehiclesByEuropeanEmissionStandard(EuropeanEmissionStandard.valueOf(europeanEmissionStandard));
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/vehicles/horsePowerGreaterEqual")
    public ResponseEntity<Flux<VehicleDTO>> getAllVehiclesByHorsePowerGreater(@RequestParam("horsePowerGreaterEqual") Integer horsePowerGreaterEqual) {
        Flux<VehicleDTO> vehicles = this.vehicleService.findVehicleByHorsePowerGreaterThanEqual(horsePowerGreaterEqual);
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/vehicles/horsePowerLesserEqual")
    public ResponseEntity<Flux<VehicleDTO>> getAllVehiclesByHorsePowerLesser(@RequestParam("horsePowerLesserEqual") Integer horsePowerLesserEqual) {
        Flux<VehicleDTO> vehicles = this.vehicleService.findVehicleByHorsePowerLessThanEqual(horsePowerLesserEqual);
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/vehicles/manufactureDateAfter")
    public ResponseEntity<Flux<VehicleDTO>> getAllVehiclesByManufactureDateAfter(@RequestParam("manufactureDateAfter") Date manufactureDateAfter) {
        Flux<VehicleDTO> vehicles = this.vehicleService.findVehiclesByManufactureDateAfter(manufactureDateAfter);
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/vehicles/manufactureDateBefore")
    public ResponseEntity<Flux<VehicleDTO>> getAllVehiclesByCreatedDateBefore(@RequestParam("manufactureDateBefore") Date manufactureDateBefore) {
        Flux<VehicleDTO> vehicles = this.vehicleService.findVehiclesByManufactureDateBefore(manufactureDateBefore);
        return ResponseEntity.ok().body(vehicles);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Void> addNewVehicle(@RequestBody VehicleDTO vehicleDTO) {
        this.vehicleService.addNewVehicle(vehicleDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/vehicles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicleById(@PathVariable("id") Long id) {
        this.vehicleService.deleteVehicleById(id);
    }

    @DeleteMapping("/vehicles/licensePlate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicleById(@RequestParam("licensePlate") String licensePlate) {
        this.vehicleService.deleteVehicleByLicensePlate(licensePlate);
    }

}
