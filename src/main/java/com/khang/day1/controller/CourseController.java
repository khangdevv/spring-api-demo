package com.khang.day1.controller;

import com.khang.day1.common.ApiResponse;
import com.khang.day1.common.exception.NotFoundException;
import com.khang.day1.domain.entity.Course;
import com.khang.day1.dto.course.CourseInsertRequest;
import com.khang.day1.dto.course.CourseResponse;
import com.khang.day1.dto.course.CourseUpdateRequest;
import com.khang.day1.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseResponse>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(courseService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(courseService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponse>> create(@Valid @RequestBody CourseInsertRequest course) {
        return new ResponseEntity<>(ApiResponse.success("Course created successfully", courseService.save(course)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponse>> update(@PathVariable Long id, @Valid @RequestBody CourseUpdateRequest course) throws NotFoundException {
        return ResponseEntity.ok(ApiResponse.success("Course updated successfully", courseService.update(id, course)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) throws NotFoundException {
        courseService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Course deleted successfully"));
    }
}
