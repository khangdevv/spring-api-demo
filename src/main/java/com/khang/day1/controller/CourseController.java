package com.khang.day1.controller;

import com.khang.day1.common.ApiResponse;
import com.khang.day1.domain.entity.Course;
import com.khang.day1.service.CourseService;
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
    public ResponseEntity<ApiResponse<List<Course>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(courseService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(courseService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> create(@RequestBody Course course) {
        return new ResponseEntity<>(ApiResponse.success("Course created successfully", courseService.save(course)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> update(@PathVariable Long id, @RequestBody Course course) {
        return ResponseEntity.ok(ApiResponse.success("Course updated successfully", courseService.update(id, course)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        courseService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Course deleted successfully"));
    }
}
