package com.example.schoolmanager.unittests.mapper.mocks;

import com.example.schoolmanager.data.dto.v1.TeacherDto;
import com.example.schoolmanager.models.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockTeacher {

    public Teacher mockEntity() {
        return mockEntity(0);
    }

    public TeacherDto mockDto() {
        return mockDto(0);
    }

    public List<Teacher> mockEntityList() {
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            teachers.add(mockEntity(i));
        }
        return teachers;
    }

    public List<TeacherDto> mockDtoList() {
        List<TeacherDto> teachers = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            teachers.add(mockDto(i));
        }
        return teachers;
    }

    public Teacher mockEntity(Integer number) {
        Teacher teacher = new Teacher();
        teacher.setRgm(number.longValue());
        teacher.setName("Name Test" + number);
        teacher.setEmail("Email Test" + number);
        teacher.setHiringDate(LocalDate.of(2024, 1, 1));
        return teacher;
    }

    public TeacherDto mockDto(Integer number) {
        TeacherDto teacher = new TeacherDto();
        teacher.setKey(number.longValue());
        teacher.setName("Name Test" + number);
        teacher.setEmail("Email Test" + number);
        teacher.setHiringDate(LocalDate.of(2024, 1, 1));
        return teacher;
    }
}
