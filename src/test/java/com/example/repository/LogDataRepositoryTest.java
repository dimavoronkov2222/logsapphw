package com.example.repository;
import com.example.model.LogData;
import com.example.model.LogLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class LogDataRepositoryTest {
    @Autowired
    private LogDataRepository repository;
    private LogData logData;
    @BeforeEach
    public void setUp() {
        logData = new LogData();
        logData.setLevel(LogLevel.INFO);
        logData.setSrc("test-service");
        logData.setMessage("Test log message");
    }
    @Test
    public void testSaveLogData() {
        LogData savedLog = repository.save(logData);
        assertThat(savedLog).isNotNull();
        assertThat(savedLog.getId()).isNotNull();
    }
    @Test
    public void testFindAllLogs() {
        repository.save(logData);
        var logs = repository.findAll();
        assertThat(logs).isNotEmpty();
    }
}