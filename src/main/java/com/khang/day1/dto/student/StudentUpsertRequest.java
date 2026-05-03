package com.khang.day1.dto.student;

import com.khang.day1.domain.entity.Parent;
import com.khang.day1.domain.enums.Gender;
import com.khang.day1.domain.enums.StudentStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Size(min = 5, max = 20, message = "Student code must be between 5 and 20 characters")
    String studentCode;

    String fullName;

    LocalDateTime dateOfBirth;

    Gender gender;

    String gradeLevel;

    String schoolName;

    @Pattern(regexp = "^(84|0[3|5789])+([0-9]{8})$", message = "Phone number must be a valid Vietnamese phone number")
    String phone;

    @Min(value = 1, message = "Parent ID must be greater than or equal to 1")
    Long parent_id;

    StudentStatus status = StudentStatus.ACTIVE;

    @Min(value = 0, message = "Latest score must be greater than or equal to 0")
    @Max(value = 10, message = "Latest score must be less than or equal to 10")
    BigDecimal latestScore;

    String note;
}
