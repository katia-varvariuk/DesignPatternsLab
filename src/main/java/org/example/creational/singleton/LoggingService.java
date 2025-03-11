package org.example.creational.singleton;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LoggingService {
    private static LoggingService instance;
    private final List<String> logs;

    private LoggingService() {
        this.logs = new ArrayList<>();
    }

    public static synchronized LoggingService getInstance() {
        if (instance == null) {
            instance = new LoggingService();
        }
        return instance;
    }

    public void log(String message) {
        String timestamp = LocalDateTime.now().toString();
        String logEntry = "[" + timestamp + "] " + message;
        logs.add(logEntry);
        System.out.println(logEntry);
    }

    public void logInfo(String message) {
        log("INFO: " + message);
    }

    public void logWarning(String message) {
        log("WARNING: " + message);
    }

    public void logError(String message) {
        log("ERROR: " + message);
    }

    public List<String> getLogs() {
        return new ArrayList<>(logs);
    }

    public void clearLogs() {
        logs.clear();
    }
}