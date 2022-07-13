package com.ivssim.vehicle.controllers;

import com.ivssim.clients.vehicle.EuropeanEmissionStandard;
import com.ivssim.clients.vehicle.FuelType;
import com.ivssim.clients.vehicle.VehicleDTO;
import com.ivssim.clients.vehicle.VehicleType;
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
    public Mono<VehicleDTO> getVehicleById(@PathVariable("id") Long id) {
        return this.vehicleService.findVehicleById(id);
    }

    @GetMapping("/vehicles/licensePlate")
    public Mono<VehicleDTO> getVehicleByLicensePlate(@RequestParam("licensePlate") String licensePlate) {
        return this.vehicleService.findVehicleByLicensePlate(licensePlate);
    }

    @GetMapping("/vehicles")
    public Flux<VehicleDTO> getAllVehicles() {
        return this.vehicleService.findAllVehicles();
    }

    @GetMapping("/vehicles/brand")
    public Flux<VehicleDTO> getAllVehiclesByBrand(@RequestParam("brand") String brand) {
        return this.vehicleService.findVehiclesByBrand(brand);
    }

    @GetMapping("/vehicles/vehicleType")
    public Flux<VehicleDTO> getAllVehiclesByVehicleType(@RequestParam("vehicleType") String vehicleType) {
        return this.vehicleService.findVehiclesByVehicleType(VehicleType.valueOf(vehicleType));
    }

    @GetMapping("/vehicles/fuelType")
    public Flux<VehicleDTO> getAllVehiclesByFuelType(@RequestParam("fuelType") String fuelType) {
        return this.vehicleService.findVehiclesByFuelType(FuelType.valueOf(fuelType));
    }

    @GetMapping("/vehicles/europeanEmissionStandard")
    public Flux<VehicleDTO> getAllVehiclesByEuropeanEmissionStandard(@RequestParam("europeanEmissionStandard") String europeanEmissionStandard) {
        return this.vehicleService.findVehiclesByEuropeanEmissionStandard(EuropeanEmissionStandard.valueOf(europeanEmissionStandard));
    }

    @GetMapping("/vehicles/horsePowerGreaterEqual")
    public Flux<VehicleDTO> getAllVehiclesByHorsePowerGreater(@RequestParam("horsePowerGreaterEqual") Integer horsePowerGreaterEqual) {
        return this.vehicleService.findVehicleByHorsePowerGreaterThanEqual(horsePowerGreaterEqual);
    }

    @GetMapping("/vehicles/horsePowerLesserEqual")
    public Flux<VehicleDTO> getAllVehiclesByHorsePowerLesser(@RequestParam("horsePowerLesserEqual") Integer horsePowerLesserEqual) {
        return this.vehicleService.findVehicleByHorsePowerLessThanEqual(horsePowerLesserEqual);
    }

    @GetMapping("/vehicles/manufactureDateAfter")
    public Flux<VehicleDTO> getAllVehiclesByManufactureDateAfter(@RequestParam("manufactureDateAfter") Date manufactureDateAfter) {
        return this.vehicleService.findVehiclesByManufactureDateAfter(manufactureDateAfter);
    }

    @GetMapping("/vehicles/manufactureDateBefore")
    public Flux<VehicleDTO> getAllVehiclesByCreatedDateBefore(@RequestParam("manufactureDateBefore") Date manufactureDateBefore) {
        return this.vehicleService.findVehiclesByManufactureDateBefore(manufactureDateBefore);
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
