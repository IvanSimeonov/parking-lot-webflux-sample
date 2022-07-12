package com.ivssim.vehicle.domains;


import com.ivssim.vehicle.enums.EuropeanEmissionStandard;
import com.ivssim.vehicle.enums.FuelType;
import com.ivssim.vehicle.enums.VehicleType;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO implements Serializable {

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
