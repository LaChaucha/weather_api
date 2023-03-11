package com.example.weather.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class GetWeatherByLocationPetition {
    private Location location;
    private Unit unit;
    private Language lang;
}
