package com.khang.day1.service.impl;

import com.khang.day1.common.exception.NotFoundException;
import com.khang.day1.domain.entity.Course;
import com.khang.day1.domain.entity.Student;
import com.khang.day1.dto.course.CourseInsertRequest;
import com.khang.day1.dto.course.CourseResponse;
import com.khang.day1.dto.course.CourseUpdateRequest;
import com.khang.day1.repository.CourseRepository;
import com.khang.day1.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CourseResponse> findAll() {
        return courseRepository.findAll().stream()
                .map(this::map)
                .toList();
    }

    @Override
    public CourseResponse findById(Long id) {
        return modelMapper.map(courseRepository.findById(id), CourseResponse.class);
    }

    @Override
    public CourseResponse save(CourseInsertRequest course) {
        return map(courseRepository.save(modelMapper.map(course, Course.class)));
    }

    @Override
    public CourseResponse update(Long id, CourseUpdateRequest course) {
        Course existingCourse = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        modelMapper.map(course, existingCourse);
        return map(courseRepository.save(existingCourse));
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        courseRepository.deleteById(id);
    }

    private CourseResponse map(Course course) {
        return modelMapper.map(course, CourseResponse.class);
    }
}
