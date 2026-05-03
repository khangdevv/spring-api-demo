package com.khang.day1.service.impl;

import com.khang.day1.domain.entity.Course;
import com.khang.day1.repository.CourseRepository;
import com.khang.day1.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Long id, Course course) {
        Course existingCourse = findById(id);
        
        existingCourse.setCourseCode(course.getCourseCode());
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setTuitionFee(course.getTuitionFee());
        existingCourse.setTotalSessions(course.getTotalSessions());
        existingCourse.setIsActive(course.getIsActive());
        
        return courseRepository.save(existingCourse);
    }

    @Override
    public void deleteById(Long id) {
        Course existingCourse = findById(id);
        courseRepository.delete(existingCourse);
    }
}
