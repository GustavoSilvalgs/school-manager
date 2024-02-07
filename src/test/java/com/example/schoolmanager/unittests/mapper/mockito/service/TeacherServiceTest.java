package com.example.schoolmanager.unittests.mapper.mockito.service;

import com.example.schoolmanager.models.Teacher;
import com.example.schoolmanager.repositories.TeacherRepository;
import com.example.schoolmanager.services.TeacherService;
import com.example.schoolmanager.unittests.mapper.mocks.MockTeacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class TeacherServiceTest {

    MockTeacher input;

    @InjectMocks
    private TeacherService service;

    @Mock
    TeacherRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockTeacher();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Teacher entity = input.mockEntity(1);
        entity.setRgm(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.getTeacherByRgm(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/teacher/v1/1>;rel=\"self\"]"));
        assertEquals("Name Test1", result.getName());
        assertEquals("Email Test1", result.getEmail());
        assertEquals("2024-01-01", result.getHiringDate().toString());
    }
}
