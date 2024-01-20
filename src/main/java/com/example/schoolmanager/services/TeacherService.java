package com.example.schoolmanager.services;

import com.example.schoolmanager.data.dto.TeacherDto;
import com.example.schoolmanager.mapper.DozerMapper;
import com.example.schoolmanager.models.Teacher;
import com.example.schoolmanager.repositories.TeacherRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public TeacherDto create(TeacherDto teacher) {
        var entity = DozerMapper.parseObject(teacher, Teacher.class);
        return DozerMapper.parseObject(repository.save(entity), TeacherDto.class);
    }

    public TeacherDto getTeacherByRgm(Long rgm) {
        var entity = repository.findById(rgm).orElse(null);
        return DozerMapper.parseObject(entity, TeacherDto.class);
    }

    public List<TeacherDto> getAllTeachers() {
        return DozerMapper.parseListObjects(repository.findAll(), TeacherDto.class);
    }

    public TeacherDto updateTeacher(TeacherDto teacher) {
        var entity = repository.findById(teacher.getRgm())
                .orElseThrow(() -> new EntityNotFoundException("User with RGM " + teacher.getRgm() + " not found"));

        entity.setName(teacher.getName());
        entity.setEmail(teacher.getEmail());
        entity.setHiringDate(teacher.getHiringDate());

        return DozerMapper.parseObject(repository.save(entity), TeacherDto.class);
    }

    public void deleteTeacher(Long rgm) {
        repository.deleteById(rgm);
    }
}
