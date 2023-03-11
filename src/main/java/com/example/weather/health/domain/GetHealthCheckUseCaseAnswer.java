package com.example.weather.health.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GetHealthCheckUseCaseAnswer {
    private final static long RETURN_CODE = 200;
    private String message = "The services is running.";
}
