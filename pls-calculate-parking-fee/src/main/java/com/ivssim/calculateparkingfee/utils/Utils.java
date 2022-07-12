package com.ivssim.calculateparkingfee.utils;

import com.ivssim.calculateparkingfee.enums.EuropeanEmissionStandard;
import com.ivssim.calculateparkingfee.enums.FuelType;
import com.ivssim.calculateparkingfee.enums.VehicleType;

import java.util.Calendar;
import java.util.Date;

public class Utils {
    private final static Double BASE_PRICE = 9.99;
    private final static Calendar calendar = Calendar.getInstance();

    public static int getCurrentYear() {
        calendar.setTime(new Date());
        return calendar.get(Calendar.YEAR);
    }

    public static int getManufactureYear(Date date) {
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getManufactureYearIndex(Date date) {
        int currentYear = getCurrentYear();
        int manufactureYear = getManufactureYear(date);
        int result = currentYear - manufactureYear;
        return result <= 0 ? 1 : result;
    }

    public static Double getHorsePowerIndex(Integer horsePower) {
        if (horsePower < 100) {
            return 0.5;
        } else {
            if (horsePower < 300) {
                return 0.7;
            } else {
                return 0.9;
            }
        }
    }

    public static Double getFuelTypeIndex(FuelType fuelType) {
        return switch (fuelType) {
            case ELECTRICITY -> 0.2;
            case ETHANOL -> 0.4;
            case BIO_DIESEL -> 0.5;
            case GASOLINE -> 0.8;
            case DIESEL -> 0.9;
        };
    }

    public static Double getVehicleTypeIndex(VehicleType vehicleType) {
        return switch (vehicleType) {
            case HATCHBACK, SEDAN -> 0.5;
            case SUV, VAN -> 0.6;
            case PICKUP -> 0.7;
            case TRUCK, CAMPERVAN -> 0.8;
        };
    }

    public static Double getEuropeanEmissionStandardIndex(EuropeanEmissionStandard europeanEmissionStandard) {
        return switch (europeanEmissionStandard) {
            case EURO_1 -> 0.9;
            case EURO_2 -> 0.8;
            case EURO_3 -> 0.7;
            case EURO_4 -> 0.6;
            case EURO_5 -> 0.3;
            case EURO_6 -> 0.1;
        };
    }


    public static Double calculateFee(Date manufactureDate, Integer horsePower, FuelType fuelType, VehicleType vehicleType, EuropeanEmissionStandard europeanEmissionStandard) {
        int yearIndex = getManufactureYearIndex(manufactureDate);
        Double horsePowerIndex = getHorsePowerIndex(horsePower);
        Double fuelTypeIndex = getFuelTypeIndex(fuelType);
        Double vehicleTypeIndex = getVehicleTypeIndex(vehicleType);
        Double europeanEmissionStandardIndex = getEuropeanEmissionStandardIndex(europeanEmissionStandard);
        return BASE_PRICE * (yearIndex + horsePowerIndex + fuelTypeIndex + vehicleTypeIndex + europeanEmissionStandardIndex);

    }


}
