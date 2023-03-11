package com.example.weather.weather.adapters.impl;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.weather.weather.adapters.dto.OpenweathermapResponse;
import com.example.weather.weather.domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;

import java.io.FileInputStream;
import java.nio.charset.Charset;

@RestClientTest(WeatherHttpSecondaryAdapter.class)
@ContextConfiguration(classes = WeatherHttpSecondaryAdapter.class)
@ActiveProfiles("TEST")
class WeatherHttpSecondaryAdapterTest {

    @Autowired
    public Environment env;

    @Autowired
    private MockRestServiceServer mockServer;
    @Autowired
    private WeatherHttpSecondaryAdapter weatherHttpSecondaryAdapter;
    private static final ObjectMapper mapper = new ObjectMapper();
    private String mockWeatherUrl;

    @BeforeEach
    void setUp() {
        mockWeatherUrl = env.getProperty("openweathermap.url");
    }

    @Test
    void testWhenTheWeatherPetitionEnteredValid_thenReturnHttp200() throws Exception {

        final FileInputStream fileInputStream = new FileInputStream(ResourceUtils.getFile("classpath:responseOnecallFromOpenWeatherMap_http200.json"));
        final String staticResponse = StreamUtils.copyToString(fileInputStream, Charset.defaultCharset());

        OpenweathermapResponse mockOpenweathermapResponse = mapper.readValue(staticResponse, OpenweathermapResponse.class);

        mockServer
                .expect(requestTo(mockWeatherUrl))
                .andRespond(withSuccess(mapper.writeValueAsString(mockOpenweathermapResponse), MediaType.APPLICATION_JSON));

        WeatherPetition weatherPetition = new WeatherPetition(
                Location.ARGENTINA,
                Unit.METRIC,
                Language.ES
        );

        WeatherMeasure weatherMeasureMocked = weatherHttpSecondaryAdapter.apply(weatherPetition);

        mockServer.verify();

        assertEquals(weatherMeasureMocked.getTimezone(),"America/Argentina/Salta");
        assertThat(weatherMeasureMocked).isEqualTo(getWeatherMeasureMock());

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
                "5.61",
                "296",
                "7.94",
                "800",
                "Clear",
                "cielo claro",
                "01d"
        );
    }
}