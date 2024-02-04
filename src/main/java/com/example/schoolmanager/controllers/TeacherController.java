package com.example.schoolmanager.controllers;

import com.example.schoolmanager.data.dto.v1.TeacherDto;
import com.example.schoolmanager.services.TeacherService;
import com.example.schoolmanager.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher/v1")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public TeacherDto create(@RequestBody TeacherDto teacher) {
        return service.create(teacher);
    }

    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public TeacherDto getTeacherById(@PathVariable(value = "id") Long id) {
        return service.getTeacherByRgm(id);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public List<TeacherDto> getAllTeachers() {
        return service.getAllTeachers();
    }

    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public TeacherDto update(@RequestBody TeacherDto teacher) {
        return service.updateTeacher(teacher);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}