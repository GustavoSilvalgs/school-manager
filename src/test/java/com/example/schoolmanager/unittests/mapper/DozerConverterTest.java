package com.example.schoolmanager.unittests.mapper;

import com.example.schoolmanager.data.dto.v1.TeacherDto;
import com.example.schoolmanager.mapper.DozerMapper;
import com.example.schoolmanager.models.Teacher;
import com.example.schoolmanager.unittests.mapper.mocks.MockTeacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DozerConverterTest {

    MockTeacher inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockTeacher();
    }

    @Test
    public void parseEntityToDTOTest() {
        TeacherDto output = DozerMapper.parseObject(inputObject.mockEntity(), TeacherDto.class);
        assertEquals(Long.valueOf(0L), output.getKey());
        assertEquals("Name Test0", output.getName());
        assertEquals("Email Test0", output.getEmail());
        assertEquals(LocalDate.of(2024, 1, 1), output.getHiringDate());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<TeacherDto> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), TeacherDto.class);
        TeacherDto outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getKey());
        assertEquals("Name Test0", outputZero.getName());
        assertEquals("Email Test0", outputZero.getEmail());
        assertEquals(LocalDate.of(2024, 1, 1), outputZero.getHiringDate());

        TeacherDto outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getKey());
        assertEquals("Name Test7", outputSeven.getName());
        assertEquals("Email Test7", outputSeven.getEmail());
        assertEquals(LocalDate.of(2024, 1, 1), outputSeven.getHiringDate());

        TeacherDto outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        assertEquals("Name Test12", outputTwelve.getName());
        assertEquals("Email Test12", outputTwelve.getEmail());
        assertEquals(LocalDate.of(2024, 1, 1), outputTwelve.getHiringDate());
    }

    @Test
    public void parseDTOToEntityTest() {
        Teacher output = DozerMapper.parseObject(inputObject.mockDto(), Teacher.class);
        assertEquals(Long.valueOf(0L), output.getRgm());
        assertEquals("Name Test0", output.getName());
        assertEquals("Email Test0", output.getEmail());
        assertEquals(LocalDate.of(2024, 1, 1), output.getHiringDate());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Teacher> outputList = DozerMapper.parseListObjects(inputObject.mockDtoList(), Teacher.class);
        Teacher outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getRgm());
        assertEquals("Name Test0", outputZero.getName());
        assertEquals("Email Test0", outputZero.getEmail());
        assertEquals(LocalDate.of(2024, 1, 1), outputZero.getHiringDate());

        Teacher outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getRgm());
        assertEquals("Name Test7", outputSeven.getName());
        assertEquals("Email Test7", outputSeven.getEmail());
        assertEquals(LocalDate.of(2024, 1, 1), outputSeven.getHiringDate());

        Teacher outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getRgm());
        assertEquals("Name Test12", outputTwelve.getName());
        assertEquals("Email Test12", outputTwelve.getEmail());
        assertEquals(LocalDate.of(2024, 1, 1), outputTwelve.getHiringDate());
    }
}
