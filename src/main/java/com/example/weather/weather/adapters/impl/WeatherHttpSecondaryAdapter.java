package com.example.weather.weather.adapters.impl;

import com.example.weather.utils.ObjectConverter;
import com.example.weather.weather.WeatherRepositoryInterface;
import com.example.weather.weather.adapters.dto.OpenweathermapResponse;
import com.example.weather.weather.domain.WeatherMeasure;
import com.example.weather.weather.domain.WeatherPetition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class WeatherHttpSecondaryAdapter implements WeatherRepositoryInterface {
    @Autowired
    public Environment env;
    private RestTemplate restTemplate;

    @Autowired
    public WeatherHttpSecondaryAdapter(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/onecall")
    @Override
    public WeatherMeasure apply(WeatherPetition weatherPetition ) {
        Map<String, String> map = new HashMap<>();
        map.put("lat", env.getProperty("coordinates." + weatherPetition.getLocation().getCountryCode() + ".lat"));
        map.put("lon", env.getProperty("coordinates." + weatherPetition.getLocation().getCountryCode() + ".lon"));
        map.put("appId", env.getProperty("openweathermap.appId"));
        map.put("units", weatherPetition.getUnit().name());
        map.put("lang", weatherPetition.getLang().name());
        OpenweathermapResponse measure = restTemplate.getForObject(env.getProperty("openweathermap.url"), OpenweathermapResponse.class, map);
        return ObjectConverter.convertToWeatherMeasure(measure);
    }
}