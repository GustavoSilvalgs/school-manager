package com.example.schoolmanager.unittests.mapper.mocks;

import com.example.schoolmanager.data.dto.v1.StudentDto;
import com.example.schoolmanager.models.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockStudent {

    public Student mockEntity() {
        return mockEntity(0);
    }

    public StudentDto mockDto() {
        return mockDto(0);
    }

    public List<Student> mockEntityList() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            students.add(mockEntity(i));
        }
        return students;
    }

    public List<StudentDto> mockDtoList() {
        List<StudentDto> students = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            students.add(mockDto(i));
        }
        return students;
    }

    public Student mockEntity(Integer number) {
        Student student = new Student();
        student.setRgm(number.longValue());
        student.setName("Name Test" + number);
        student.setEmail("Email Test" + number);
        student.setRegistrationDate(LocalDate.of(2024, 1, 1));
        return student;
    }

    public StudentDto mockDto(Integer number) {
        StudentDto student = new StudentDto();
        student.setRgm(number.longValue());
        student.setName("Name Test" + number);
        student.setEmail("Email Test" + number);
        student.setRegistrationDate(LocalDate.of(2024, 1, 1));
        return student;
    }
}
