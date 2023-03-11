package com.example.weather.health.adapters.impl;

import com.example.weather.health.GetHealthCheckUseCaseInterface;
import com.example.weather.health.domain.GetHealthCheckUseCaseAnswer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@WebMvcTest(HealthHttpPrimaryAdapter.class)
@ContextConfiguration(classes = HealthHttpPrimaryAdapter.class)
public class HealthHttpPrimaryAdapterTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetHealthCheckUseCaseInterface getHealthCheckUseCaseMocked;

    @DisplayName("Ping Should Return Running Message From Service")
    @Test
    public void testWhenPingServerIsRunning_thenResponseHttp200AndRunningLegend() throws Exception {

        GetHealthCheckUseCaseAnswer pingOk = new GetHealthCheckUseCaseAnswer();

        doReturn(pingOk).when(getHealthCheckUseCaseMocked).apply(null);

        this.mockMvc.perform(get("/ping"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("The services is running.")))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}
