package com.example.schoolmanager.controllers;

import com.example.schoolmanager.data.dto.TeacherDto;
import com.example.schoolmanager.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping
    public TeacherDto create(@RequestBody TeacherDto teacher) {
        return service.create(teacher);
    }

    @GetMapping(value = "/{id}")
    public TeacherDto getTeacherById(@PathVariable(value = "id") Long id) {
        return service.getTeacherByRgm(id);
    }

    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        return service.getAllTeachers();
    }

    @PutMapping
    public TeacherDto update(@RequestBody TeacherDto teacher) {
        return service.updateTeacher(teacher);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
