package com.ivssim.calculateparkingfee.services;

import com.ivssim.calculateparkingfee.enums.EuropeanEmissionStandard;
import com.ivssim.calculateparkingfee.enums.FuelType;
import com.ivssim.calculateparkingfee.enums.VehicleType;
import com.ivssim.calculateparkingfee.models.Vehicle;
import com.ivssim.calculateparkingfee.utils.Utils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class CalculateParkingFeeServiceImpl implements CalculateParkingFeeService {

    @Override
    public Mono<Double> calculateFee(Mono<Vehicle> vehicleMono) {

        return vehicleMono.map(vehicle -> {
            Integer horsePower = vehicle.getHorsePower();
            VehicleType vehicleType = vehicle.getVehicleType();
            FuelType fuelType = vehicle.getFuelType();
            EuropeanEmissionStandard europeanEmissionStandard = vehicle.getEuropeanEmissionStandard();
            Date manufactureDate = vehicle.getManufactureDate();
            return Utils.calculateFee(manufactureDate, horsePower, fuelType, vehicleType, europeanEmissionStandard);
        });

    }
}
