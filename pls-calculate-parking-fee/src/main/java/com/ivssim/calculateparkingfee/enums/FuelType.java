package com.ivssim.calculateparkingfee.enums;

import lombok.Getter;

@Getter
public enum FuelType {
    GASOLINE("G"),
    DIESEL("D"),
    BIO_DIESEL("BD"),
    ETHANOL("ET"),
    ELECTRICITY("EL");

    private final String code;

    FuelType(String code) {
        this.code = code;
    }
}