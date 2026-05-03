package com.khang.day1.dto.student;

import com.khang.day1.domain.entity.Parent;
import com.khang.day1.domain.enums.Gender;
import com.khang.day1.domain.enums.StudentStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentUpsertRequest {
    String studentCode;
    String fullName;
    LocalDateTime dateOfBirth;
    Gender gender;
    String gradeLevel;
    String schoolName;
    String phone;
    Long parent_id;
    StudentStatus status = StudentStatus.ACTIVE;
    BigDecimal latestScore;
    String note;
}
