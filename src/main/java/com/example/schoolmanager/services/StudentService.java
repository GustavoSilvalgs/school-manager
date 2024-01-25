package com.example.schoolmanager.services;

import com.example.schoolmanager.data.dto.StudentDto;
import com.example.schoolmanager.exceptions.RequiredObjectIsNullException;
import com.example.schoolmanager.exceptions.ResourceAlreadyExistsException;
import com.example.schoolmanager.exceptions.ResourceNotFoundException;
import com.example.schoolmanager.mapper.DozerMapper;
import com.example.schoolmanager.models.Student;
import com.example.schoolmanager.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public StudentDto create(StudentDto student) {

        if (student == null) throw new RequiredObjectIsNullException();

        if (repository.existsByEmail(student.getEmail()))
            throw new ResourceAlreadyExistsException("Email already exists");

        var entity = DozerMapper.parseObject(student, Student.class);
        return DozerMapper.parseObject(repository.save(entity), StudentDto.class);
    }

    public StudentDto getStudentByRgm(Long rgm) {
        var entity = repository.findById(rgm)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this RGM!"));
        return DozerMapper.parseObject(entity, StudentDto.class);
    }
}
