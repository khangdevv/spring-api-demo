package com.khang.day1.service;

import com.khang.day1.domain.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    
    Course findById(Long id);
    
    Course save(Course course);
    
    Course update(Long id, Course course);
    
    void deleteById(Long id);
}
