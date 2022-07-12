package com.ivssim.vehicle.repositories;

import com.ivssim.vehicle.enums.EuropeanEmissionStandard;
import com.ivssim.vehicle.enums.FuelType;
import com.ivssim.vehicle.enums.VehicleType;
import com.ivssim.vehicle.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findVehicleById(Long id);

    Vehicle findVehicleByLicensePlate(String licensePlate);

    List<Vehicle> findVehiclesByBrand(String brand);

    List<Vehicle> findVehiclesByVehicleType(VehicleType vehicleType);

    List<Vehicle> findVehiclesByFuelType(FuelType fuelType);

    List<Vehicle> findVehiclesByEuropeanEmissionStandard(EuropeanEmissionStandard europeanEmissionStandard);

    List<Vehicle> findVehicleByHorsePowerGreaterThanEqual(Integer horsePower);

    List<Vehicle> findVehicleByHorsePowerLessThanEqual(Integer horsePower);

    List<Vehicle> findVehiclesByManufactureDateAfter(Date date);

    List<Vehicle> findVehiclesByManufactureDateBefore(Date date);

    Long removeByLicensePlate(String licensePlate);
}