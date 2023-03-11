package com.example.weather.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GetHealthCheckUseCaseAnswerUnitTest {
    private final static long RETURN_CODE = 200;
    private String message = "The services is running.";
}
