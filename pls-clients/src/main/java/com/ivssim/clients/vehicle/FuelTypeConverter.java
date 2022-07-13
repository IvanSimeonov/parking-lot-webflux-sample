package com.ivssim.clients.vehicle;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class FuelTypeConverter implements AttributeConverter<FuelType, String> {
    @Override
    public String convertToDatabaseColumn(FuelType fuelType) {
        if (fuelType == null) {
            return null;
        }
        return fuelType.getCode();
    }

    @Override
    public FuelType convertToEntityAttribute(final String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(FuelType.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
