package com.khang.day1.controller;

import com.khang.day1.common.ApiResponse;
import com.khang.day1.domain.entity.Student;
import com.khang.day1.dto.student.StudentResponse;
import com.khang.day1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponse>>> findAll() {
        List<StudentResponse> studentResponseList = studentService.findAll();
        return ResponseEntity.ok(ApiResponse.success(studentResponseList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> findById(@PathVariable Long id) {
        StudentResponse studentResponse = studentService.findById(id);
        return ResponseEntity.ok(ApiResponse.success(studentResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponse>> save(@RequestBody Student student) {
        StudentResponse studentResponse = studentService.create(student);
        return ResponseEntity.ok(ApiResponse.success(studentResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> update(@RequestBody Student student, @PathVariable Long id) {
        StudentResponse studentResponse = studentService.update(student, id);
        return ResponseEntity.ok(ApiResponse.success(studentResponse));
    }
}
