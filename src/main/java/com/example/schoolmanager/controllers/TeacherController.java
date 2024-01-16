package com.example.schoolmanager.controllers;

import com.example.schoolmanager.models.Teacher;
import com.example.schoolmanager.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping
    public Teacher create(@RequestBody Teacher teacher) {
        return service.create(teacher);
    }
}
