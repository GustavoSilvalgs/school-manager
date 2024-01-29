package com.example.schoolmanager.data.dto.v2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class TeacherDtoV2 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long rgm;
    private String name;
    private String email;
    private LocalDate hiringDate;
    private Date birthday;

    public TeacherDtoV2() {
    }

    public TeacherDtoV2(Long rgm, String name, String email, LocalDate hiringDate, Date birthday) {
        this.rgm = rgm;
        this.name = name;
        this.email = email;
        this.hiringDate = hiringDate;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherDtoV2 teacher = (TeacherDtoV2) o;
        return Objects.equals(rgm, teacher.rgm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rgm);
    }
}
