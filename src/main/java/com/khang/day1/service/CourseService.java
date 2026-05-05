package com.khang.day1.service;

import com.khang.day1.common.exception.NotFoundException;
import com.khang.day1.domain.entity.Course;
import com.khang.day1.dto.course.CourseInsertRequest;
import com.khang.day1.dto.course.CourseResponse;
import com.khang.day1.dto.course.CourseUpdateRequest;

import java.util.List;

public interface CourseService {
    List<CourseResponse> findAll();
    
    CourseResponse findById(Long id);
    
    CourseResponse save(CourseInsertRequest course);
    
    CourseResponse update(Long id, CourseUpdateRequest course) throws NotFoundException;
    
    void deleteById(Long id) throws NotFoundException;
}
