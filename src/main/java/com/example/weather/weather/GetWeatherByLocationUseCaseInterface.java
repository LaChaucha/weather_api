package com.example.weather.weather;

import com.example.weather.weather.domain.GetWeatherByLocationAnswer;
import com.example.weather.weather.domain.GetWeatherByLocationPetition;

import java.util.function.Function;

@FunctionalInterface
public interface GetWeatherByLocationUseCaseInterface extends Function<GetWeatherByLocationPetition, GetWeatherByLocationAnswer> {
}
