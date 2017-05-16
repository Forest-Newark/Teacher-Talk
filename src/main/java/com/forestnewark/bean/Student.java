package com.forestnewark.bean;



import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

//@Entity is telling JPA tht the Student class is a JPA entity  and this can be persisted to a database
@Entity
@Proxy(lazy=false)
public class Student{
//@Id this tells JPA that private int id is the primary key for this entity.
// @GeneratedValue this tells JPA that JPA should automatically generate this key for the entity
    @Id
    @GeneratedValue
    private int id;

    private String studentFirstName;
    private String studentLastName;
    private String grade;
    private String school;
    private String notes;

//@OnetoOne is establishing a one to one relationship with the parent class
    @OneToOne (cascade = CascadeType.ALL)
    private Parent parent;


    public Student() {
    }
//constructors for the student class


    public Student(String studentFirstName, String studentLastName, String grade, String school, String notes) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.grade = grade;
        this.school = school;
        this.notes = notes;
    }

    public Student(String studentFirstName, String studentLastName, String grade, String school, String notes, Parent parent) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.grade = grade;
        this.school = school;
        this.notes = notes;
        this.parent = parent;
    }
//establishing getters and setters for the Student class
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentFirstName='" + studentFirstName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                ", notes='" + notes + '\'' +
                ", parent=" + parent +
                '}';
    }
}
