package com.ivssim.calculateparkingfee.services;

import com.ivssim.calculateparkingfee.utils.Utils;
import com.ivssim.clients.vehicle.EuropeanEmissionStandard;
import com.ivssim.clients.vehicle.FuelType;
import com.ivssim.clients.vehicle.VehicleDTO;
import com.ivssim.clients.vehicle.VehicleType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class CalculateParkingFeeServiceImpl implements CalculateParkingFeeService {

    @Override
    public Mono<Double> calculateFee(Mono<VehicleDTO> vehicleMono) {

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
