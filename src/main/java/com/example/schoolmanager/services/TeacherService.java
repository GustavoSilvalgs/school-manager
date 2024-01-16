package com.example.schoolmanager.services;

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

    public Teacher create(Teacher teacher) {
        return repository.save(teacher);
    }

    public Teacher getTeacherByRgm(Long rgm) {
        return repository.findById(rgm).orElse(null);
    }

    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    public void updateTeacher(Teacher teacher) {
        var entity = repository.findById(teacher.getRgm())
                .orElseThrow(() -> new EntityNotFoundException("User with RGM " + teacher.getRgm() + " not found"));

        if (teacher.getName() != null) {
            entity.setName(teacher.getName());
        }

        if (teacher.getEmail() != null) {
            entity.setEmail(teacher.getEmail());
        }

        repository.save(entity);
    }
}
