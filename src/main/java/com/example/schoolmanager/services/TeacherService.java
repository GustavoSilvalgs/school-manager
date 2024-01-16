package com.example.schoolmanager.services;

import com.example.schoolmanager.models.Teacher;
import com.example.schoolmanager.repositories.TeacherRepository;
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
}
