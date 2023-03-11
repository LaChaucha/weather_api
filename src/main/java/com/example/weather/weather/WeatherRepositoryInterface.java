package com.example.weather.weather;

import com.example.weather.weather.domain.WeatherMeasure;
import com.example.weather.weather.domain.WeatherPetition;

import java.util.function.Function;

@FunctionalInterface
public interface WeatherRepositoryInterface extends Function<WeatherPetition, WeatherMeasure> {
}
