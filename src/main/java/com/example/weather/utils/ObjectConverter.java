package com.example.weather.utils;

import com.example.weather.core.ObjectApplicationConverter;
import com.example.weather.weather.adapters.dto.OpenweathermapResponse;
import com.example.weather.weather.domain.*;

public final class ObjectConverter extends ObjectApplicationConverter {

    public static WeatherMeasure convertToWeatherMeasure(OpenweathermapResponse openweathermapResponse){
        return new WeatherMeasure(  openweathermapResponse.getLat(),
                                    openweathermapResponse.getLon(),
                                    openweathermapResponse.getTimezone_offset(),
                                    openweathermapResponse.getTimezone(),
                                    openweathermapResponse.getCurrent().getDt(),
                                    openweathermapResponse.getCurrent().getSunrise(),
                                    openweathermapResponse.getCurrent().getSunset(),
                                    openweathermapResponse.getCurrent().getTemp(),
                                    openweathermapResponse.getCurrent().getFeels_like(),
                                    openweathermapResponse.getCurrent().getPressure(),
                                    openweathermapResponse.getCurrent().getHumidity(),
                                    openweathermapResponse.getCurrent().getDew_point(),
                                    openweathermapResponse.getCurrent().getUvi(),
                                    openweathermapResponse.getCurrent().getClouds(),
                                    openweathermapResponse.getCurrent().getVisibility(),
                                    openweathermapResponse.getCurrent().getWind_speed(),
                                    openweathermapResponse.getCurrent().getWind_deg(),
                                    openweathermapResponse.getCurrent().getWind_gust(),
                                    openweathermapResponse.getCurrent().getWeather().get(0).getId(),
                                    openweathermapResponse.getCurrent().getWeather().get(0).getMain(),
                                    openweathermapResponse.getCurrent().getWeather().get(0).getDescription(),
                                    openweathermapResponse.getCurrent().getWeather().get(0).getIcon()
        );
    }

    public static GetWeatherByLocationPetition convertToGetWeatherByLocationPetition(String location, String units, String lang ){
        return new GetWeatherByLocationPetition(Location.fromCountryCode(location.toUpperCase()),
                                                Unit.valueOf(units.toUpperCase()),
                                                Language.valueOf(lang.toUpperCase()));
    }

}
