package com.khang.day1.domain.entity;

import com.khang.day1.domain.AuditableEntity;
import com.khang.day1.domain.enums.TeacherRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "teachers")
public class Teacher extends AuditableEntity {

    @Column(columnDefinition = "varchar(20)")
    private String teacherCode;

    @Column(columnDefinition = "varchar(100)")
    private String fullName;

    @Column(columnDefinition = "varchar(20)")
    private String phone;

    @Email
    @Column(columnDefinition = "varchar(100)")
    private String email;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private TeacherRole role = TeacherRole.TEACHER;

    @Column(columnDefinition = "varchar(255)")
    private String id_card_url;

    private Boolean active;
}
