package com.khang.day1.service;

import com.khang.day1.common.exception.NotFoundException;
import com.khang.day1.domain.entity.Student;
import com.khang.day1.dto.student.StudentResponse;
import com.khang.day1.dto.student.StudentUpdateRequest;
import com.khang.day1.dto.student.StudentUpsertRequest;

import java.util.List;

public interface StudentService {
    List<StudentResponse> findAll();

    StudentResponse findById(Long id);

    StudentResponse update(StudentUpdateRequest student, Long id) throws NotFoundException;

    StudentResponse create(StudentUpsertRequest student);

    void deleteById(Long id) throws NotFoundException;
}
