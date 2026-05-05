package com.khang.day1.service.impl;

import com.khang.day1.domain.entity.Parent;
import com.khang.day1.domain.entity.Student;
import com.khang.day1.dto.student.StudentResponse;
import com.khang.day1.dto.student.StudentUpdateRequest;
import com.khang.day1.dto.student.StudentUpsertRequest;
import com.khang.day1.repository.ParentRepository;
import com.khang.day1.repository.StudentRepository;
import com.khang.day1.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;
    private final ModelMapper modelMapper;

    public List<StudentResponse> findAll() {
        return studentRepository.findAll().stream()
                .map(this::map)
                .toList();
    }

    public StudentResponse findById(Long id) {
        return modelMapper.map(studentRepository.findById(id), StudentResponse.class);
    }

    @Override
    public StudentResponse update(StudentUpdateRequest student, Long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        modelMapper.map(student, existingStudent);
        return map(studentRepository.save(existingStudent));
    }

    @Override
    public StudentResponse create(StudentUpsertRequest student) {
        Long parent_id = student.getParent_id();
        Parent parent = parentRepository.findById(parent_id).orElseThrow(() -> new RuntimeException("Parent not found with id: " + parent_id));
        return map(studentRepository.save(modelMapper.map(student, Student.class)));
    }

    @Override
    public void deleteById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepository.deleteById(id);
    }

    private StudentResponse map(Student student) {
        return modelMapper.map(student, StudentResponse.class);
    }
}
