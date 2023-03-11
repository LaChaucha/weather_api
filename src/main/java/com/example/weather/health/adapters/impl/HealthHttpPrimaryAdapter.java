package com.example.weather.health.adapters.impl;

import com.example.weather.health.GetHealthCheckUseCaseInterface;
import com.example.weather.health.domain.GetHealthCheckUseCaseAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthHttpPrimaryAdapter {

    @Autowired
    private GetHealthCheckUseCaseInterface getHealthCheckUseCase;

    @GetMapping("/ping")
    public GetHealthCheckUseCaseAnswer ping() {
        return getHealthCheckUseCase.apply(null);
    }
}