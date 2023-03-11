package com.example.weather.health.impl;

import com.example.weather.health.GetHealthCheckUseCaseInterface;
import com.example.weather.health.domain.GetHealthCheckUseCaseAnswer;
import org.springframework.stereotype.Service;

@Service
public class GetHealthCheckUseCase implements GetHealthCheckUseCaseInterface {

    @Override
    public GetHealthCheckUseCaseAnswer apply(Void unused) {
        return new GetHealthCheckUseCaseAnswer();
    }
}