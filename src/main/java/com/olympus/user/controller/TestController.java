package com.olympus.user.controller;

import java.time.Instant;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
// This allows your React Vite app (port 5173) to send requests to this controller:
@CrossOrigin(origins = "http://localhost:5173")
public class TestController {

    @GetMapping("/health")
    public Map<String, Object> healthCheck() {
        return Map.of(
            "status", "UP",
            "service", "Nexus Backend",
            "timestamp", Instant.now().toString()
        );
    }
}