package com.khang.day1.domain.entity;

import java.math.BigDecimal;

import com.khang.day1.domain.enums.Gender;
import com.khang.day1.domain.enums.StudentStatus;

import com.khang.day1.domain.AuditableEntity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student extends AuditableEntity {

    @Column(name = "student_code", columnDefinition = "varchar(20)")
    private String studentCode;

    @Column(name = "full_name", columnDefinition = "varchar(100)")
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "grade_level", columnDefinition = "varchar(30)")
    private String gradeLevel;

    @Column(name = "school_name", columnDefinition = "varchar(100)")
    private String schoolName;

    @Column(columnDefinition = "varchar(20)")
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @Column(name = "latest_score", columnDefinition = "decimal(5,2)")
    private BigDecimal latestScore;

    @Column(columnDefinition = "varchar(255)")
    private String note;
}
