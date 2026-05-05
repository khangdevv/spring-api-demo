package com.khang.day1.controller;

import com.khang.day1.common.ApiResponse;
import com.khang.day1.common.exception.NotFoundException;
import com.khang.day1.domain.entity.Teacher;
import com.khang.day1.dto.teacher.TeacherInsertRequest;
import com.khang.day1.dto.teacher.TeacherResponse;
import com.khang.day1.dto.teacher.TeacherUpdateRequest;
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
    public ResponseEntity<ApiResponse<List<TeacherResponse>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(teacherService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(teacherService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TeacherResponse>> create(@RequestBody TeacherInsertRequest teacher) {
        return new ResponseEntity<>(ApiResponse.success("Teacher created successfully", teacherService.save(teacher)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherResponse>> update(@PathVariable Long id, @RequestBody TeacherUpdateRequest teacher) throws NotFoundException {
        return ResponseEntity.ok(ApiResponse.success("Teacher updated successfully", teacherService.update(id, teacher)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) throws NotFoundException {
        teacherService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Teacher deleted successfully"));
    }
}
