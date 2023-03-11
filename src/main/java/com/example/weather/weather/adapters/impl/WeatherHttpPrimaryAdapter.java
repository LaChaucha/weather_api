package com.example.weather.weather.adapters.impl;

import com.example.weather.utils.ObjectConverter;
import com.example.weather.weather.GetWeatherByLocationUseCaseInterface;
import com.example.weather.weather.adapters.dto.Language;
import com.example.weather.weather.adapters.dto.Location;
import com.example.weather.weather.adapters.dto.Unit;
import com.example.weather.weather.domain.GetWeatherByLocationAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class WeatherHttpPrimaryAdapter {
    @Autowired
    private GetWeatherByLocationUseCaseInterface weather;

    @GetMapping("/weather")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetWeatherByLocationAnswer weather(@RequestParam (required = true) Location code,
                                              @RequestParam (required = false, defaultValue = "METRIC") Unit units,
                                              @RequestParam (required = false, defaultValue = "ES") Language lang ) {

        return weather.apply(ObjectConverter.convertToGetWeatherByLocationPetition( code.toString(),
                                                                                    units.toString(),
                                                                                    lang.toString())
        );
    }
}