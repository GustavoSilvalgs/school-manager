package com.example.schoolmanager.controllers;

import com.example.schoolmanager.data.dto.v1.TeacherDto;
import com.example.schoolmanager.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher/v1")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public TeacherDto create(@RequestBody TeacherDto teacher) {
        return service.create(teacher);
    }

    @GetMapping(value = "/{id}",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public TeacherDto getTeacherById(@PathVariable(value = "id") Long id) {
        return service.getTeacherByRgm(id);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<TeacherDto> getAllTeachers() {
        return service.getAllTeachers();
    }

    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public TeacherDto update(@RequestBody TeacherDto teacher) {
        return service.updateTeacher(teacher);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
