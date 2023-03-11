package com.example.weather.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Location {

    ARGENTINA("Argentina","AR"),
    USA("United States","US");

    private String countryName;
    private String countryCode;

    public static Location fromCountryCode(String countryCode) {
        for (Location l : Location.values()) {
            if (l.countryCode.equalsIgnoreCase(countryCode)) {
                return l;
            }
        }
        return null;
    }
}