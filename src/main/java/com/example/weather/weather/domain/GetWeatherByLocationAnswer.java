package com.example.weather.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class GetWeatherByLocationAnswer {
    private String timezone;
    private String temp;
    private String humidity;
    private String visibility;
    private String wind_speed;
    private String main;
    private String description;
}