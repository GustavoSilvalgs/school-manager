package com.example.schoolmanager.unittests.mapper.mockito.service;

import com.example.schoolmanager.data.dto.v1.TeacherDto;
import com.example.schoolmanager.exceptions.RequiredObjectIsNullException;
import com.example.schoolmanager.exceptions.ResourceAlreadyExistsException;
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
import static org.mockito.ArgumentMatchers.any;
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

    @Test
    void testCreate() {
        Teacher entity = input.mockEntity(1);
        entity.setRgm(1L);

        entity.setRgm(1L);

        TeacherDto dto = input.mockDto(1);
        dto.setKey(1L);

        when(repository.save(entity)).thenReturn(entity);

        var result = service.create(dto);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/teacher/v1/1>;rel=\"self\"]"));
        assertEquals("Name Test1", result.getName());
        assertEquals("Email Test1", result.getEmail());
        assertEquals("2024-01-01", result.getHiringDate().toString());
    }

    @Test
    void testCreateWithNullTeacher() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.create(null);
        });

        assertEquals("It is not allowed to persist a null object!", exception.getMessage());
    }

    @Test
    void testCreateWithDuplicateEmail() {
        when(repository.existsByEmail(any())).thenReturn(true);

        TeacherDto dto = input.mockDto(1);

        Exception exception = assertThrows(ResourceAlreadyExistsException.class, () -> {
           service.create(dto);
        });

        assertEquals("Email already exists", exception.getMessage());
    }

    @Test
    void testUpdate() {
        Teacher entity = input.mockEntity(1);

        entity.setRgm(1L);

        TeacherDto dto = input.mockDto(1);
        dto.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(entity);

        var result = service.updateTeacher(dto);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/teacher/v1/1>;rel=\"self\"]"));
        assertEquals("Name Test1", result.getName());
        assertEquals("Email Test1", result.getEmail());
        assertEquals("2024-01-01", result.getHiringDate().toString());
    }

    @Test
    void testUpdateWithNullTeacher() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.updateTeacher(null);
        });

        assertEquals("It is not allowed to persist a null object!", exception.getMessage());
    }

    @Test
    void testDelete() {
        Teacher entity = input.mockEntity();
        entity.setRgm(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.deleteTeacher(1L);
    }
}
