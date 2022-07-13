package com.ivssim.vehicle.models;


import com.ivssim.clients.vehicle.EuropeanEmissionStandard;
import com.ivssim.clients.vehicle.FuelType;
import com.ivssim.clients.vehicle.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Version
    private Long version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type", nullable = false)
    private VehicleType vehicleType;

    @Column(name = "license_plate", nullable = false, unique = true)
    private String licensePlate;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacture_date", nullable = false)
    private Date manufactureDate;

    @Column(name = "european_emission_standard", nullable = false)
    private EuropeanEmissionStandard europeanEmissionStandard;

    @Column(name = "horse_power", nullable = false)
    private Integer horsePower;

    @Column(name = "fuel_type", nullable = false)
    private FuelType fuelType;
}
