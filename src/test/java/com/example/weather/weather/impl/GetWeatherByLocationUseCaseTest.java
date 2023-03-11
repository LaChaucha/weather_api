package com.example.weather.weather.impl;

import static com.example.weather.weather.domain.Language.ES;
import static com.example.weather.weather.domain.Location.ARGENTINA;
import static com.example.weather.weather.domain.Unit.METRIC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.weather.core.ObjectApplicationConverter;
import com.example.weather.weather.WeatherRepositoryInterface;
import com.example.weather.weather.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(GetWeatherByLocationUseCase.class)
@ContextConfiguration(classes = GetWeatherByLocationUseCase.class)
class GetWeatherByLocationUseCaseTest {

    @MockBean
    private WeatherRepositoryInterface weatherRepository;
    private GetWeatherByLocationAnswer getWeatherByLocationAnswerExpected;

    @Test
    void testWhenWeatherByLocationUseCaseEnteredValidParams_thenReturnWeatherByLocationAnswer() {

        getWeatherByLocationAnswerExpected = new GetWeatherByLocationAnswer(
                "America/Argentina/Salta",
                "31.65",
                "28",
                "10000",
                "1.52",
                "Clouds",
                "nubes"
        );

        when(weatherRepository.apply(any())).thenReturn(getWeatherMeasureMock());

        GetWeatherByLocationUseCase getWeatherByLocationUseCase = new GetWeatherByLocationUseCase(weatherRepository);

        GetWeatherByLocationAnswer getWeatherByLocationAnswerActual = getWeatherByLocationUseCase.apply(getWeatherByLocationPetitionMock());

        assertEquals(getWeatherByLocationAnswerExpected.getDescription(),getWeatherByLocationAnswerActual.getDescription());
        assertThat(getWeatherByLocationAnswerActual).isEqualTo(getWeatherByLocationAnswerExpected);

    }

    private GetWeatherByLocationPetition getWeatherByLocationPetitionMock(){
        return new GetWeatherByLocationPetition(
                ARGENTINA,
                METRIC,
                ES
        );
    }
    private WeatherMeasure getWeatherMeasureMock() {
        return new WeatherMeasure(
                "-38.4161",
                "-63.6167",
                "-10800",
                "America/Argentina/Salta",
                "1678305277",
                "1678269928",
                "1678315526",
                "31.65",
                "30.22",
                "1008",
                "28",
                "10.93",
                "2.42",
                "4",
                "10000",
                "1.52",
                "296",
                "7.94",
                "800",
                "Clouds",
                "nubes",
                "01d"
        );
    }
}