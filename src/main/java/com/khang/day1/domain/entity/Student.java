package com.khang.day1.domain.entity;

import java.time.LocalDateTime;

import com.khang.day1.domain.enums.Gender;
import com.khang.day1.domain.enums.StudentStatus;
import org.hibernate.annotations.Parent;

import com.khang.day1.domain.AuditableEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String studentCode;

    @Column(columnDefinition = "varchar(100)")
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(columnDefinition = "varchar(30)")
    private String gradeLevel;

    @Column(columnDefinition = "varchar(100)")
    private String schoolName;

    @Column(columnDefinition = "varchar(20)")
    private String phone;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;
}
