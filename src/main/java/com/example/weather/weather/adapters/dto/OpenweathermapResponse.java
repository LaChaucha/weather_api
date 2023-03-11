package com.example.weather.weather.adapters.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement
public class OpenweathermapResponse {

    private String lat;
    private String lon;
    private String timezone_offset;
    private String timezone;
    private Current current;

    @Data
    public static class Current {
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
        private List<WeatherResponse> weather;

        @Data
        public static class WeatherResponse {
            private String id;
            private String main;
            private String description;
            private String icon;

        }
    }
}
