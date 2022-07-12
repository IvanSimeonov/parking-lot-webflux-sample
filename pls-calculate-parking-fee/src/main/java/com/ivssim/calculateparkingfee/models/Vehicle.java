package com.ivssim.calculateparkingfee.models;

import com.ivssim.calculateparkingfee.enums.EuropeanEmissionStandard;
import com.ivssim.calculateparkingfee.enums.FuelType;
import com.ivssim.calculateparkingfee.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {


    private Long id;

    private Long version;

    private Timestamp createdDate;

    private Timestamp lastModifiedDate;

    private VehicleType vehicleType;

    private String licensePlate;

    private String brand;

    private String model;

    private Date manufactureDate;

    private EuropeanEmissionStandard europeanEmissionStandard;

    private Integer horsePower;

    private FuelType fuelType;

}

