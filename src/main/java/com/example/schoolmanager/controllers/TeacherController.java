package com.example.schoolmanager.controllers;

import com.example.schoolmanager.models.Teacher;
import com.example.schoolmanager.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping
    public Teacher create(@RequestBody Teacher teacher) {
        return service.create(teacher);
    }

    @GetMapping(value = "/{id}")
    public Teacher getTeacherById(@PathVariable(value = "id") Long id) {
        return service.getTeacherByRgm(id);
    }
}
