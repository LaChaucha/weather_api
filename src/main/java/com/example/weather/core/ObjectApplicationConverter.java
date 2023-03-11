package com.example.weather.core;

import com.example.weather.weather.domain.GetWeatherByLocationAnswer;
import com.example.weather.weather.domain.GetWeatherByLocationPetition;
import com.example.weather.weather.domain.WeatherMeasure;
import com.example.weather.weather.domain.WeatherPetition;

public abstract class ObjectApplicationConverter {
    public static WeatherPetition convertToWeatherPetition(GetWeatherByLocationPetition getWeatherByLocationPetition) {
        return new WeatherPetition(getWeatherByLocationPetition.getLocation(),
                getWeatherByLocationPetition.getUnit(),
                getWeatherByLocationPetition.getLang());
    }

    public static GetWeatherByLocationAnswer convertToGetWeatherByLocationAnswer(WeatherMeasure weatherMeasure) {
        return new GetWeatherByLocationAnswer(weatherMeasure.getTimezone(),
                weatherMeasure.getTemp(),
                weatherMeasure.getHumidity(),
                weatherMeasure.getVisibility(),
                weatherMeasure.getWind_speed(),
                weatherMeasure.getMain(),
                weatherMeasure.getDescription());
    }
}
