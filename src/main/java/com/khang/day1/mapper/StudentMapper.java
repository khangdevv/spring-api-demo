package com.khang.day1.mapper;

<<<<<<< HEAD
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface StudentMapper {
=======
import com.khang.day1.domain.entity.Student;
import com.khang.day1.dto.student.StudentResponse;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentResponse toStudentResponse(Student student);
    List<StudentResponse> toStudentResponseList(List<Student> studentList);
>>>>>>> demo_day2
}
