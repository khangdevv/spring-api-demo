package com.khang.day1.controller;

import com.khang.day1.common.ApiResponse;
import com.khang.day1.domain.entity.Course;
import com.khang.day1.domain.entity.Parent;
import com.khang.day1.domain.entity.Teacher;
import com.khang.day1.service.ParentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Parent>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(parentService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Parent>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(parentService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Parent>> create(@RequestBody Parent parent) {
        return new ResponseEntity<>(ApiResponse.success("Parent created successfully", parentService.save(parent)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Parent>> update(@PathVariable Long id, @RequestBody Parent parent) {
        return ResponseEntity.ok(ApiResponse.success("Parent updated successfully", parentService.update(id, parent)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        parentService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Parent deleted successfully"));
    }
}
