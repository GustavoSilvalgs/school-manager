package com.example.schoolmanager.data.dto.v1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TeacherDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long rgm;
    private String name;
    private String email;
    private LocalDate hiringDate;

    public TeacherDto() {
    }

    public TeacherDto(Long rgm, String name, String email, LocalDate hiringDate) {
        this.rgm = rgm;
        this.name = name;
        this.email = email;
        this.hiringDate = hiringDate;
    }

    public Long getRgm() {
        return rgm;
    }

    public void setRgm(Long rgm) {
        this.rgm = rgm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherDto teacher = (TeacherDto) o;
        return Objects.equals(rgm, teacher.rgm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rgm);
    }
}
