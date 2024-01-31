package com.example.schoolmanager.controllers;

import com.example.schoolmanager.data.dto.v1.StudentDto;
import com.example.schoolmanager.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/v1")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public StudentDto create(@RequestBody StudentDto student) {
        return service.create(student);
    }

    @GetMapping(value = "/{id}")
    public StudentDto getStudentById(@PathVariable(value = "id") Long id) {
        return service.getStudentByRgm(id);
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return service.getAllStudents();
    }

    @PutMapping
    public StudentDto update(@RequestBody StudentDto student) {
        return service.updateStudent(student);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
