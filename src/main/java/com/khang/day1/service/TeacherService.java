package com.khang.day1.service;

import com.khang.day1.common.exception.NotFoundException;
import com.khang.day1.domain.entity.Teacher;
import com.khang.day1.dto.teacher.TeacherInsertRequest;
import com.khang.day1.dto.teacher.TeacherResponse;
import com.khang.day1.dto.teacher.TeacherUpdateRequest;

import java.util.List;

public interface TeacherService {
    List<TeacherResponse> findAll();

    TeacherResponse findById(Long id);

    TeacherResponse save(TeacherInsertRequest teacher);

    TeacherResponse update(Long id, TeacherUpdateRequest teacher) throws NotFoundException;

    void deleteById(Long id) throws NotFoundException;
}
