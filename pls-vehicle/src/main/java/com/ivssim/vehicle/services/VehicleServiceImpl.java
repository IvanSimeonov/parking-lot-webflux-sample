package com.ivssim.vehicle.services;

import com.ivssim.vehicle.domains.VehicleDTO;
import com.ivssim.vehicle.enums.EuropeanEmissionStandard;
import com.ivssim.vehicle.enums.FuelType;
import com.ivssim.vehicle.enums.VehicleType;
import com.ivssim.vehicle.mappers.VehicleMapper;
import com.ivssim.vehicle.models.Vehicle;
import com.ivssim.vehicle.repositories.VehicleRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    VehicleRepository vehicleRepository;
    VehicleMapper vehicleMapper;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        vehicleMapper = Mappers.getMapper(VehicleMapper.class);
    }

    @Override
    public Mono<VehicleDTO> findVehicleById(Long id) {
        return Mono.just(this.vehicleMapper.toDTO(this.vehicleRepository.findVehicleById(id)));
    }

    @Override
    public Mono<VehicleDTO> findVehicleByLicensePlate(String licensePlate) {
        return Mono.just(this.vehicleMapper.toDTO(this.vehicleRepository.findVehicleByLicensePlate(licensePlate)));
    }

    @Override
    public Flux<VehicleDTO> findAllVehicles() {
        return Flux.fromIterable(this.vehicleRepository.findAll().stream().map(vehicleMapper::toDTO).collect(Collectors.toList()));
    }

    @Override
    public Flux<VehicleDTO> findVehiclesByVehicleType(VehicleType vehicleType) {
        return Flux.fromIterable(this.vehicleRepository.findVehiclesByVehicleType(vehicleType)
                .stream()
                .map(vehicleMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public Flux<VehicleDTO> findVehiclesByBrand(String brand) {
        return Flux.fromIterable(this.vehicleRepository.findVehiclesByBrand(brand)
                .stream()
                .map(vehicleMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public Flux<VehicleDTO> findVehiclesByManufactureDateAfter(Date date) {
        return Flux.fromIterable(this.vehicleRepository.findVehiclesByManufactureDateAfter(date)
                .stream()
                .map(vehicleMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public Flux<VehicleDTO> findVehiclesByManufactureDateBefore(Date date) {
        return Flux.fromIterable(this.vehicleRepository.findVehiclesByManufactureDateBefore(date)
                .stream()
                .map(vehicleMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public Flux<VehicleDTO> findVehiclesByEuropeanEmissionStandard(EuropeanEmissionStandard europeanEmissionStandard) {
        return Flux.fromIterable(this.vehicleRepository.findVehiclesByEuropeanEmissionStandard(europeanEmissionStandard)
                .stream()
                .map(vehicleMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public Flux<VehicleDTO> findVehicleByHorsePowerGreaterThanEqual(Integer horsePower) {
        return Flux.fromIterable(this.vehicleRepository.findVehicleByHorsePowerGreaterThanEqual(horsePower)
                .stream()
                .map(vehicleMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public Flux<VehicleDTO> findVehicleByHorsePowerLessThanEqual(Integer horsePower) {
        return Flux.fromIterable(this.vehicleRepository.findVehicleByHorsePowerLessThanEqual(horsePower)
                .stream()
                .map(vehicleMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public Flux<VehicleDTO> findVehiclesByFuelType(FuelType fuelType) {
        return Flux.fromIterable(this.vehicleRepository.findVehiclesByFuelType(fuelType)
                .stream()
                .map(vehicleMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public void addNewVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicleToSave = this.vehicleMapper.toEntity(vehicleDTO);
        this.vehicleRepository.save(vehicleToSave);
    }

    @Override
    public void deleteVehicleById(Long id) {
        this.vehicleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteVehicleByLicensePlate(String licensePlate) {
        this.vehicleRepository.removeByLicensePlate(licensePlate);
    }
}
