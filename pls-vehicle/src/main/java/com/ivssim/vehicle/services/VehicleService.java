package com.ivssim.vehicle.services;


import com.ivssim.clients.vehicle.EuropeanEmissionStandard;
import com.ivssim.clients.vehicle.FuelType;
import com.ivssim.clients.vehicle.VehicleDTO;
import com.ivssim.clients.vehicle.VehicleType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface VehicleService {

    Mono<VehicleDTO> findVehicleById(Long id);

    Mono<VehicleDTO> findVehicleByLicensePlate(String licensePlate);

    Flux<VehicleDTO> findAllVehicles();

    Flux<VehicleDTO> findVehiclesByBrand(String brand);

    Flux<VehicleDTO> findVehiclesByVehicleType(VehicleType vehicleType);

    Flux<VehicleDTO> findVehiclesByFuelType(FuelType fuelType);

    Flux<VehicleDTO> findVehiclesByEuropeanEmissionStandard(EuropeanEmissionStandard europeanEmissionStandard);

    Flux<VehicleDTO> findVehicleByHorsePowerGreaterThanEqual(Integer horsePower);

    Flux<VehicleDTO> findVehicleByHorsePowerLessThanEqual(Integer horsePower);

    Flux<VehicleDTO> findVehiclesByManufactureDateAfter(Date date);

    Flux<VehicleDTO> findVehiclesByManufactureDateBefore(Date date);

    void addNewVehicle(VehicleDTO vehicleDTO);

    void deleteVehicleById(Long id);

    void deleteVehicleByLicensePlate(String licensePlate);
}