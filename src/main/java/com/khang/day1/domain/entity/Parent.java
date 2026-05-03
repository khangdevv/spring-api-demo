package com.khang.day1.domain.entity;

import com.khang.day1.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "parents")
public class Parent extends AuditableEntity {

    @Column(columnDefinition = "varchar(100)")
    private String fullName;

    @Column(columnDefinition = "varchar(20)")
    private String phoneNumber;

    @Email
    @Column(columnDefinition = "varchar(100)")
    private String email;

    @Column(columnDefinition = "text")
    private String address;
}
