package com.khang.day1.domain.entity;

<<<<<<< HEAD
import java.time.LocalDateTime;

import com.khang.day1.domain.enums.Gender;
import com.khang.day1.domain.enums.StudentStatus;
import org.hibernate.annotations.Parent;
=======
import java.math.BigDecimal;

import com.khang.day1.domain.enums.Gender;
import com.khang.day1.domain.enums.StudentStatus;
>>>>>>> demo_day2

import com.khang.day1.domain.AuditableEntity;

import jakarta.persistence.*;
import lombok.*;
<<<<<<< HEAD
=======
import java.time.LocalDate;
>>>>>>> demo_day2

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD
@Table(name = "student")
public class Student extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String studentCode;

    @Column(columnDefinition = "varchar(100)")
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;
=======
@Table(name = "students")
public class Student extends AuditableEntity {

    @Column(name = "student_code", columnDefinition = "varchar(20)")
    private String studentCode;

    @Column(name = "full_name", columnDefinition = "varchar(100)")
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
>>>>>>> demo_day2

    @Enumerated(EnumType.STRING)
    private Gender gender;

<<<<<<< HEAD
    @Column(columnDefinition = "varchar(30)")
    private String gradeLevel;

    @Column(columnDefinition = "varchar(100)")
=======
    @Column(name = "grade_level", columnDefinition = "varchar(30)")
    private String gradeLevel;

    @Column(name = "school_name", columnDefinition = "varchar(100)")
>>>>>>> demo_day2
    private String schoolName;

    @Column(columnDefinition = "varchar(20)")
    private String phone;

<<<<<<< HEAD
    @Enumerated(EnumType.STRING)
    private StudentStatus status;
=======
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @Column(name = "latest_score", columnDefinition = "decimal(5,2)")
    private BigDecimal latestScore;

    @Column(columnDefinition = "varchar(255)")
    private String note;
>>>>>>> demo_day2
}
