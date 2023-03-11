package com.example.weather.weather.adapters.impl;

import com.example.weather.utils.WhenWeatherEnteredValidParams_thenReturnHttp200;
import com.example.weather.weather.GetWeatherByLocationUseCaseInterface;
import com.example.weather.weather.domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherHttpPrimaryAdapter.class)
@ContextConfiguration(classes = WeatherHttpPrimaryAdapter.class)
public class WeatherHttpPrimaryAdapterUnitTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private GetWeatherByLocationUseCaseInterface weather;

    @Test
    public void testWhenWeatherEnteredValidParams_thenReturnHttp200() throws Exception {

        WhenWeatherEnteredValidParams_thenReturnHttp200 whenWeatherEnteredValidParams_thenReturnHttp200 = new WhenWeatherEnteredValidParams_thenReturnHttp200();

        GetWeatherByLocationAnswer getWeatherByLocationAnswerMocked = new GetWeatherByLocationAnswer(
                "America/Argentina/Salta",
                "35.92",
                "11",
                "10000",
                "5.22",
                null,
                null
        );
        doReturn(getWeatherByLocationAnswerMocked).when(weather).apply(any());
        this.mockMvc.perform(get("/weather")
                .param("code", "AR")
                .param("units", "METRIC")
                .param("lang", "ES")
                )
                .andDo(print())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writer().writeValueAsString(whenWeatherEnteredValidParams_thenReturnHttp200)));
    }
}