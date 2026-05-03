package com.khang.day1.controller;

import com.khang.day1.common.ApiResponse;
import com.khang.day1.domain.entity.Teacher;
import com.khang.day1.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Teacher>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(teacherService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Teacher>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(teacherService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Teacher>> create(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(ApiResponse.success("Teacher created successfully", teacherService.save(teacher)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Teacher>> update(@PathVariable Long id, @RequestBody Teacher teacher) {
        return ResponseEntity.ok(ApiResponse.success("Teacher updated successfully", teacherService.update(id, teacher)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        teacherService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Teacher deleted successfully"));
    }
}
