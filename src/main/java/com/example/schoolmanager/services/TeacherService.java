package com.example.schoolmanager.services;

import com.example.schoolmanager.data.dto.TeacherDto;
import com.example.schoolmanager.exceptions.RequiredObjectIsNullException;
import com.example.schoolmanager.exceptions.ResourceNotFoundException;
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

        if (teacher == null) throw new RequiredObjectIsNullException();

        var entity = DozerMapper.parseObject(teacher, Teacher.class);
        return DozerMapper.parseObject(repository.save(entity), TeacherDto.class);
    }

    public TeacherDto getTeacherByRgm(Long rgm) {
        var entity = repository.findById(rgm)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this RGM!"));
        return DozerMapper.parseObject(entity, TeacherDto.class);
    }

    public List<TeacherDto> getAllTeachers() {
        return DozerMapper.parseListObjects(repository.findAll(), TeacherDto.class);
    }

    public TeacherDto updateTeacher(TeacherDto teacher) {
        var entity = repository.findById(teacher.getRgm())
                .orElseThrow(() -> new ResourceNotFoundException("No records found this RGM!"));

        entity.setName(teacher.getName());
        entity.setEmail(teacher.getEmail());
        entity.setHiringDate(teacher.getHiringDate());

        return DozerMapper.parseObject(repository.save(entity), TeacherDto.class);
    }

    public void deleteTeacher(Long rgm) {
        var entity = repository.findById(rgm)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this RGM!"));
    }
}
