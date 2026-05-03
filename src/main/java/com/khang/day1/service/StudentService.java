package com.khang.day1.service;

<<<<<<< HEAD
import com.khang.day1.domain.entity.Student;
=======

import com.khang.day1.domain.entity.Student;
import com.khang.day1.dto.student.StudentResponse;
import com.khang.day1.dto.student.StudentUpsertRequest;
>>>>>>> demo_day2

import java.util.List;

public interface StudentService {
<<<<<<< HEAD
    List<Student> findAll();
=======
    List<StudentResponse> findAll();

    StudentResponse findById(Long id);

    StudentResponse update(StudentUpsertRequest student, Long id);

    StudentResponse create(StudentUpsertRequest student);

    void deleteById(Long id);
>>>>>>> demo_day2
}
