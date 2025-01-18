package com.example.controller;
import com.example.model.LogData;
import com.example.model.LogLevel;
import com.example.service.LogDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
@SpringBootTest
@AutoConfigureMockMvc
public class LogDataControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private LogDataService service;
    private LogData logData;
    @BeforeEach
    public void setUp() {
        logData = new LogData();
        logData.setLevel(LogLevel.INFO);
        logData.setSrc("test-service");
        logData.setMessage("Test log message");
    }
    @Test
    public void testSaveLog() throws Exception {
        when(service.saveLogData(any(LogData.class))).thenReturn(logData);
        mockMvc.perform(post("/api/logs")
                        .contentType("application/json")
                        .content("{\"level\":\"INFO\",\"src\":\"test-service\",\"message\":\"Test log message\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1, \"level\":\"INFO\", \"src\":\"test-service\", \"message\":\"Test log message\"}"));
    }
}