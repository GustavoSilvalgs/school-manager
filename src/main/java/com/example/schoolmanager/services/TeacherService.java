package com.example.schoolmanager.services;

import com.example.schoolmanager.models.Teacher;
import com.example.schoolmanager.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public Teacher create(Teacher teacher) {
        return repository.save(teacher);
    }
}
