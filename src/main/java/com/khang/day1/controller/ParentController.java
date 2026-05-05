package com.khang.day1.controller;

import com.khang.day1.common.ApiResponse;
import com.khang.day1.common.exception.NotFoundException;
import com.khang.day1.domain.entity.Course;
import com.khang.day1.domain.entity.Parent;
import com.khang.day1.domain.entity.Teacher;
import com.khang.day1.dto.parent.ParentInsertRequest;
import com.khang.day1.dto.parent.ParentResponse;
import com.khang.day1.dto.parent.ParentUpdateRequest;
import com.khang.day1.service.ParentService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ApiResponse<List<ParentResponse>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(parentService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ParentResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(parentService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ParentResponse>> create(@Valid @RequestBody ParentInsertRequest parent) {
        return new ResponseEntity<>(ApiResponse.success("Parent created successfully", parentService.save(parent)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ParentResponse>> update(@PathVariable Long id, @Valid @RequestBody ParentUpdateRequest parent) throws NotFoundException {
        return ResponseEntity.ok(ApiResponse.success("Parent updated successfully", parentService.update(id, parent)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) throws NotFoundException {
        parentService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.successMessage("Parent deleted successfully"));
    }
}
