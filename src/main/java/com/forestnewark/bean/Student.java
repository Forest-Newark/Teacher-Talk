package com.forestnewark.bean;

/**
 * Created by cmitchell on 4/28/17.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue
    private int id;

    private String studentFirstName;
    private String studentLastName;
    private String grade;
    private String school;
    private String notes;

    public Student() {
    }

    public Student(String studentFirstName, String studentLastName, String grade, String school, String notes) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.grade = grade;
        this.school = school;
        this.notes = notes;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
