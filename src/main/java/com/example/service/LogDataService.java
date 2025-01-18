package com.example.service;
import com.example.model.LogData;
import com.example.repository.LogDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class LogDataService {
    private final LogDataRepository repository;
    public LogData saveLogData(LogData logData) {
        return repository.save(logData);
    }
    public List<LogData> getLogData(Integer limit) {
        List<LogData> allLogs = repository.findAll();
        return (limit == null) ? allLogs : allLogs.subList(0, Math.min(limit, allLogs.size()));
    }
}