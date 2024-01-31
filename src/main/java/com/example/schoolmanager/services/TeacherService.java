package com.example.schoolmanager.services;

import com.example.schoolmanager.data.dto.v1.TeacherDto;
import com.example.schoolmanager.exceptions.RequiredObjectIsNullException;
import com.example.schoolmanager.exceptions.ResourceAlreadyExistsException;
import com.example.schoolmanager.exceptions.ResourceNotFoundException;
import com.example.schoolmanager.mapper.DozerMapper;
import com.example.schoolmanager.models.Teacher;
import com.example.schoolmanager.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public TeacherDto create(TeacherDto teacher) {

        if (teacher == null) throw new RequiredObjectIsNullException();

        if (repository.existsByEmail(teacher.getEmail()))
            throw new ResourceAlreadyExistsException("Email already exists");

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

        if (!entity.getEmail().equals(teacher.getEmail())) {
            if (repository.existsByEmail(teacher.getEmail()))
                throw new ResourceAlreadyExistsException("Email already exists");
        }

        entity.setName(teacher.getName());
        entity.setEmail(teacher.getEmail());
        entity.setHiringDate(teacher.getHiringDate());

        return DozerMapper.parseObject(repository.save(entity), TeacherDto.class);
    }

    public void deleteTeacher(Long rgm) {
        var entity = repository.findById(rgm)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this RGM!"));
        repository.delete(entity);
    }
}
