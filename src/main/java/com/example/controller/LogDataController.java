package com.example.controller;
import com.example.model.LogData;
import com.example.service.LogDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class LogDataController {
    private final LogDataService service;
    @PostMapping
    public ResponseEntity<String> saveLog(@RequestBody LogData logData) {
        LogData savedLog = service.saveLogData(logData);
        return ResponseEntity.ok("{\"id\": " + savedLog.getId() + "}");
    }
    @GetMapping
    public ResponseEntity<List<LogData>> getLogs(@RequestParam(value = "limit", required = false) Integer limit) {
        List<LogData> logs = service.getLogData(limit);
        return ResponseEntity.ok(logs);
    }
}