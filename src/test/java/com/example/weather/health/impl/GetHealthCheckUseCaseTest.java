package com.example.weather.health.impl;

import com.example.weather.health.GetHealthCheckUseCaseInterface;
import com.example.weather.health.domain.GetHealthCheckUseCaseAnswer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest()
@ContextConfiguration(classes = GetHealthCheckUseCase.class)
class GetHealthCheckUseCaseTest {

    @Autowired
    GetHealthCheckUseCaseInterface getHealthCheckUseCase = new GetHealthCheckUseCase();

    @Test
    void applyShouldReturnRunningMessageFromService() {

        GetHealthCheckUseCaseAnswer getHealthCheckUseCaseAnswer = new GetHealthCheckUseCaseAnswer();

        Assertions.assertEquals(getHealthCheckUseCaseAnswer.getMessage(),getHealthCheckUseCase.apply(null).getMessage());

    }
}