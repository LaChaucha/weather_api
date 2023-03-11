package com.example.weather.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class WeatherPetition {
    private Location location;
    private Unit unit;
    private Language lang;
}
