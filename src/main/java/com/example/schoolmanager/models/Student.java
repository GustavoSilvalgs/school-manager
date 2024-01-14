package com.example.schoolmanager.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rgm;
    private String name;
    private String email;
    private LocalDate registrationDate;

    public Student() {
    }

    public Student(Long rgm, String name, String email, LocalDate registrationDate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(rgm, student.rgm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rgm);
    }
}
