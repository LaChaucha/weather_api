package com.example.weather.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@AllArgsConstructor
@Data
@Builder
public class WeatherMeasure {
    private String lat;
    private String lon;
    private String timezone_offset;
    private String timezone;
    private String dt;
    private String sunrise;
    private String sunset;
    private String temp;
    private String feels_like;
    private String pressure;
    private String humidity;
    private String dew_point;
    private String uvi;
    private String clouds;
    private String visibility;
    private String wind_speed;
    private String wind_deg;
    private String wind_gust;
    private String id;
    private String main;
    private String description;
    private String icon;

}
