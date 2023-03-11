package com.example.weather.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class WhenWeatherEnteredValidParams_thenReturnHttp200 {
    private String timezone = "America/Argentina/Salta";
    private String temp = "35.92";
    private String humidity = "11";
    private String visibility = "10000";
    private String wind_speed = "5.22";
    private String main = null;
    private String description = null;
}
