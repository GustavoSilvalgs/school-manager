package com.example.schoolmanager.controllers;

import com.example.schoolmanager.data.dto.StudentDto;
import com.example.schoolmanager.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public StudentDto create(@RequestBody StudentDto student) {
        return service.create(student);
    }
}
