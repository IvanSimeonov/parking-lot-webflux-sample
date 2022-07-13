package com.ivssim.vehicle.mappers;

import com.ivssim.clients.vehicle.VehicleDTO;
import com.ivssim.vehicle.models.Vehicle;
import org.mapstruct.Mapper;

@Mapper
public interface VehicleMapper {

    Vehicle toEntity(VehicleDTO vehicleDTO);

    VehicleDTO toDTO(Vehicle vehicle);
}
