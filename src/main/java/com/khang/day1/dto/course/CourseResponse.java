package com.khang.day1.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    Long id;
    String courseCode;
    String courseName;
    String description;
    double tuitionFee;
    int totalSessions;
    byte isActive;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
