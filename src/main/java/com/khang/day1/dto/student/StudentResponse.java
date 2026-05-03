package com.khang.day1.dto.student;

import com.khang.day1.domain.enums.Gender;
import com.khang.day1.domain.enums.StudentStatus;
import com.khang.day1.dto.parent.ParentResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    Long  id;
    String studentCode;
    String fullName;
    LocalDate dateOfBirth;
    Gender gender;
    String gradeLevel;
    String schoolName;
    String phone;
    ParentResponse parent;
    StudentStatus status;
    BigDecimal latestScore;
    String note;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
