package com.khang.day1.service;

import com.khang.day1.domain.entity.Student;
import com.khang.day1.dto.student.StudentResponse;
import com.khang.day1.dto.student.StudentUpsertRequest;

import java.util.List;

public interface StudentService {
    List<StudentResponse> findAll();

    StudentResponse findById(Long id);

    StudentResponse update(StudentUpsertRequest student, Long id);

    StudentResponse create(StudentUpsertRequest student);

    void deleteById(Long id);
}
