package com.khang.day1.domain.entity;

import com.khang.day1.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Course extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String courseCode;

    @Column(columnDefinition = "varchar(100)")
    private String courseName;

    @Column(columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "double")
    private double tuitionFee;

    private int totalSessions;

    private byte isActive;
}
