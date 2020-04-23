package com.nsbm.studentapi;

import com.sun.xml.bind.v2.TODO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
//    name, profession, email, affiliation, type (student/expert), password, etc.
    @Id
    @GeneratedValue()
    private Long id;
    private String nationalId;
    private String name;
    private String profession;
    private String email;
    private String affiliation;
    //Todo: accepted types(Student, Proffecional)
    private String type;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nationalId='" + nationalId + '\'' +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", email='" + email + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", type='" + type + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
