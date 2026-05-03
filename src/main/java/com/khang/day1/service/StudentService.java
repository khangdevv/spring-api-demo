package com.khang.day1.service;


import com.khang.day1.domain.entity.Student;
import com.khang.day1.dto.student.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> findAll();

    StudentResponse findById(Long id);

    StudentResponse update(Student student, Long id);

    StudentResponse create(Student student);

    void deleteById(Long id);
}
