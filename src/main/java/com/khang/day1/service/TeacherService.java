package com.khang.day1.service;

import com.khang.day1.domain.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    Teacher findById(Long id);

    Teacher save(Teacher teacher);

    Teacher update(Long id, Teacher teacher);

    void deleteById(Long id);
}
