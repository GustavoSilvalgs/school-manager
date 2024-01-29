package com.example.schoolmanager.data.dto.v1;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;

public class StudentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long rgm;
    private String name;
    private String email;
    private LocalDate registrationDate;

    public StudentDto() {
    }

    public StudentDto(Long rgm, String name, String email, LocalDate registrationDate) {
        this.rgm = rgm;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
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

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
