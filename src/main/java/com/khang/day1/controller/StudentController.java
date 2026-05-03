package com.khang.day1.controller;

<<<<<<< HEAD
import com.khang.day1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import com.khang.day1.common.ApiResponse;
import com.khang.day1.domain.entity.Student;
import com.khang.day1.dto.student.StudentResponse;
import com.khang.day1.dto.student.StudentUpsertRequest;
import com.khang.day1.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
>>>>>>> demo_day2

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
<<<<<<< HEAD
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok(studentService.findAll().toString());
=======
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
    public ResponseEntity<ApiResponse<StudentResponse>> save(@Valid @RequestBody StudentUpsertRequest student) {
        StudentResponse studentResponse = studentService.create(student);
        return ResponseEntity.ok(ApiResponse.success(studentResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> update(@Valid @RequestBody StudentUpsertRequest student, @PathVariable Long id) {
        StudentResponse studentResponse = studentService.update(student, id);
        return ResponseEntity.ok(ApiResponse.success(studentResponse));
>>>>>>> demo_day2
    }
}
