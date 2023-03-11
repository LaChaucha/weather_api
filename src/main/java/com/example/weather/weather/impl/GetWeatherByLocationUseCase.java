package com.example.weather.weather.impl;

import com.example.weather.core.ObjectApplicationConverter;
import com.example.weather.weather.WeatherRepositoryInterface;
import com.example.weather.weather.GetWeatherByLocationUseCaseInterface;
import com.example.weather.weather.domain.GetWeatherByLocationAnswer;
import com.example.weather.weather.domain.GetWeatherByLocationPetition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetWeatherByLocationUseCase implements GetWeatherByLocationUseCaseInterface {
    private WeatherRepositoryInterface weatherRepository;
    @Autowired
    public GetWeatherByLocationUseCase (WeatherRepositoryInterface weatherRepository){
        this.weatherRepository = weatherRepository;
    }

    @Override
    public GetWeatherByLocationAnswer apply(GetWeatherByLocationPetition getWeatherByLocationPetition) {
       return ObjectApplicationConverter.convertToGetWeatherByLocationAnswer(
               weatherRepository.apply(ObjectApplicationConverter.convertToWeatherPetition(getWeatherByLocationPetition))
       );
    }
}
