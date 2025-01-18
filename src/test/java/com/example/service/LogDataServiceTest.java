package com.example.service;
import com.example.model.LogData;
import com.example.model.LogLevel;
import com.example.repository.LogDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
public class LogDataServiceTest {
    @Mock
    private LogDataRepository repository;
    @InjectMocks
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
    public void testSaveLogData() {
        when(repository.save(any(LogData.class))).thenReturn(logData);
        LogData savedLog = service.saveLogData(logData);
        verify(repository, times(1)).save(logData);
        assert savedLog != null;
        assert savedLog.getLevel() == LogLevel.INFO;
    }
    @Test
    public void testGetLogData() {
        when(repository.findAll()).thenReturn(List.of(logData));
        List<LogData> logs = service.getLogData(null);
        verify(repository, times(1)).findAll();
        assert logs.size() == 1;
    }
}