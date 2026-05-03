package com.khang.day1.service.impl;

import com.khang.day1.domain.entity.Teacher;
import com.khang.day1.repository.TeacherRepository;
import com.khang.day1.service.TeacherService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Long id, Teacher teacher) {
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        existingTeacher.setTeacherCode(teacher.getTeacherCode());
        existingTeacher.setFullName(teacher.getFullName());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setPhone(teacher.getPhone());
        existingTeacher.setRole(teacher.getRole());
        existingTeacher.setId_card_url(teacher.getId_card_url());
        existingTeacher.setActive(teacher.getActive());

        return teacherRepository.save(existingTeacher);
    }

    @Override
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }
}
