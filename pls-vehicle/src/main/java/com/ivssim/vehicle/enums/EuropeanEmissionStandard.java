package com.ivssim.vehicle.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum EuropeanEmissionStandard {
    EURO_1(1), EURO_2(2), EURO_3(3), EURO_4(4), EURO_5(5), EURO_6(6);

    private final int standard;

    EuropeanEmissionStandard(int standard) {
        this.standard = standard;
    }

    public static EuropeanEmissionStandard of(int standard) {
        return Stream.of(EuropeanEmissionStandard.values())
                .filter(s -> s.getStandard() == standard)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
