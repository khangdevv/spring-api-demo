package com.khang.day1.dto.course;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseInsertRequest {

    @NotNull(message = "Course code cannot be null")
    private String courseCode;

    private String courseName;

    private String description;

    @NotNull(message = "Tuition fee cannot be null")
    private double tuitionFee;

    private int totalSessions;

    private byte isActive;
}
