package com.khang.day1.service.impl;

import com.khang.day1.domain.entity.Student;
import com.khang.day1.dto.student.StudentResponse;
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
    public StudentResponse update(Student student, Long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        modelMapper.map(student, existingStudent);
        return map(studentRepository.save(existingStudent));
    }

    @Override
    public StudentResponse create(Student student) {
        return modelMapper.map(studentRepository.save(student), StudentResponse.class);
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
