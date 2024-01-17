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

    public Teacher updateTeacher(Teacher teacher) {
        var entity = repository.findById(teacher.getRgm())
                .orElseThrow(() -> new EntityNotFoundException("User with RGM " + teacher.getRgm() + " not found"));

        entity.setName(teacher.getName());
        entity.setEmail(teacher.getEmail());
        entity.setHiringDate(teacher.getHiringDate());

        return repository.save(teacher);
    }

    public void deleteTeacher(Long rgm) {
        repository.deleteById(rgm);
    }
}
