package com.khang.day1.service.impl;

import com.khang.day1.domain.entity.Teacher;
import com.khang.day1.dto.teacher.TeacherInsertRequest;
import com.khang.day1.dto.teacher.TeacherResponse;
import com.khang.day1.dto.teacher.TeacherUpdateRequest;
import com.khang.day1.repository.TeacherRepository;
import com.khang.day1.service.TeacherService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TeacherResponse> findAll() {
        return teacherRepository.findAll().stream()
                .map(this::map)
                .toList();
    }

    @Override
    public TeacherResponse findById(Long id) {
        return modelMapper.map(teacherRepository.findById(id), TeacherResponse.class);
    }

    @Override
    public TeacherResponse save(TeacherInsertRequest teacher) {
        return map(teacherRepository.save(modelMapper.map(teacher, Teacher.class)));
    }

    @Override
    public TeacherResponse update(Long id, TeacherUpdateRequest teacher) {
        Teacher existingTeacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        modelMapper.map(teacher, existingTeacher);
        return map(teacherRepository.save(existingTeacher));
    }

    @Override
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    private TeacherResponse map(Teacher teacher) {
        return modelMapper.map(teacher, TeacherResponse.class);
    }
}
