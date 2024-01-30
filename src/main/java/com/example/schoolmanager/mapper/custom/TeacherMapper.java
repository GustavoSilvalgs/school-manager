package com.example.schoolmanager.mapper.custom;

import com.example.schoolmanager.data.dto.v2.TeacherDtoV2;
import com.example.schoolmanager.models.Teacher;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TeacherMapper {

    public TeacherDtoV2 convertEntityToDto(Teacher teacher) {
        TeacherDtoV2 dto = new TeacherDtoV2();
        dto.setRgm(teacher.getRgm());
        dto.setName(teacher.getName());
        dto.setEmail(teacher.getEmail());
        dto.setHiringDate(teacher.getHiringDate());
        dto.setBirthday(new Date());
        return dto;
    }

    public Teacher convertDtoToEntity(TeacherDtoV2 teacher) {
        Teacher entity = new Teacher();
        entity.setRgm(teacher.getRgm());
        entity.setName(teacher.getName());
        entity.setEmail(teacher.getEmail());
        entity.setHiringDate(teacher.getHiringDate());
        //entity.setBirthday(new Date());
        return entity;
    }
}
