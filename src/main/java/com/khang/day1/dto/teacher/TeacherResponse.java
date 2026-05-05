package com.khang.day1.dto.teacher;

import com.khang.day1.domain.enums.TeacherRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponse {
    private Long id;
    private String teacherCode;
    private String fullName;
    private String phone;
    private String email;
    private TeacherRole role = TeacherRole.TEACHER;
    private String id_card_url;
    private Boolean active;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
