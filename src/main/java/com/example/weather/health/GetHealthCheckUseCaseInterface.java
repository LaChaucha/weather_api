package com.example.weather.health;

import com.example.weather.health.domain.GetHealthCheckUseCaseAnswer;

import java.util.function.Function;
@FunctionalInterface
public interface GetHealthCheckUseCaseInterface extends Function<Void, GetHealthCheckUseCaseAnswer> {

}
