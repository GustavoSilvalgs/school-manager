package com.example.schoolmanager.data.dto.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import java.io.Serializable;
import java.time.LocalDate;

@JsonPropertyOrder({"rgm", "name", "email", "registrationDate"})
public class StudentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("rgm")
    @Mapping("rgm")
    private Long rgm;
    private String name;
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
