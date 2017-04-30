package com.forestnewark.bean;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by forestnewark on 4/29/17.
 */
public class StudentTest {
    private Student student;

    @Before
    public void setUp(){
        student = new Student("Nathan", "Walker", "Ninth", "Sanderson High", "tardy", student.getParent());
    }

    @Test
    public void getStudentFirstName() throws Exception {
        assertThat(student.getStudentFirstName(), equalTo("Nathan"));
    }

    @Test
    public void setStudentFirstName() throws Exception {
        student.setStudentFirstName("Cole");
        assertThat(student.getStudentFirstName(), equalTo("Cole"));
    }

    @Test
    public void getStudentLastName() throws Exception {
        assertThat(student.getStudentLastName(), equalTo("Walker"));
    }

    @Test
    public void setStudentLastName() throws Exception {
        student.setStudentLastName("Lee");
        assertThat(student.getStudentLastName(), equalTo("Lee"));
    }

    @Test
    public void getGrade() throws Exception {
        assertThat(student.getGrade(), equalTo("A"));
    }

    @Test
    public void setGrade() throws Exception {
        student.setGrade("C");
        assertThat(student.getGrade(), equalTo("C"));
    }

    @Test
    public void getSchool() throws Exception {
        assertThat(student.getSchool(), equalTo("Sanderson High"));
    }

    @Test
    public void setSchool() throws Exception {
        student.setSchool("Leesville High");
        assertThat(student.getSchool(), equalTo("Leesville High"));
    }

    @Test
    public void getNotes() throws Exception {
        assertThat(student.getNotes(), equalTo("tardy"));
    }

    @Test
    public void setNotes() throws Exception {
        student.setNotes("absent");
        assertThat(student.getNotes(), equalTo("absent"));
    }

    @Test
    public void getId() throws Exception {
        assertThat(student.getId(), equalTo(1));
    }

    @Test
    public void setId() throws Exception {
        student.setId(5);
        assertThat(student.getId(), equalTo(5));
    }

    @Test
    public void getParent() throws Exception {
        assertThat(student.getParent(), equalTo("Jim"));
    }

    @Test
    public void setParent() throws Exception {
        student.setParent(student.getParent());
        assertThat(student.getParent(), equalTo("Suzie"));
    }

}