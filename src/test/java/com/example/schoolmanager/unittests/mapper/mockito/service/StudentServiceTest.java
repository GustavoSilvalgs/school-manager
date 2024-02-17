package com.example.schoolmanager.unittests.mapper.mockito.service;

import com.example.schoolmanager.data.dto.v1.TeacherDto;
import com.example.schoolmanager.exceptions.RequiredObjectIsNullException;
import com.example.schoolmanager.exceptions.ResourceAlreadyExistsException;
import com.example.schoolmanager.models.Teacher;
import com.example.schoolmanager.repositories.StudentRepository;
import com.example.schoolmanager.repositories.TeacherRepository;
import com.example.schoolmanager.services.StudentService;
import com.example.schoolmanager.services.TeacherService;
import com.example.schoolmanager.unittests.mapper.mocks.MockStudent;
import com.example.schoolmanager.unittests.mapper.mocks.MockTeacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    MockStudent input;

    @InjectMocks
    private StudentService service;

    @Mock
    StudentRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockStudent();
        MockitoAnnotations.openMocks(this);
    }
}