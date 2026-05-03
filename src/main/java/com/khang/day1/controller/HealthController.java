package com.khang.day1.controller;

import com.khang.day1.common.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/api/health")
    public ApiResponse<String> healthCheck() {
        return ApiResponse.success("System is running");
    }

    @PostMapping("/api/health/echo")
    public ApiResponse<String> echo(@Valid @RequestBody EchoRequest request) {
        return ApiResponse.success("Echo: " + request.message());
    }

    public record EchoRequest(@NotBlank(message = "Message is required") String message) {}
}
