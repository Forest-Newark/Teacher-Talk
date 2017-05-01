package com.forestnewark.bean;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;


public class TeacherTest {
    private Teacher teacher;

    @Before
    public void setUp(){
        teacher = new Teacher("Niki", "Cama", "Niki@gmail.com", "qwerty", "919-438-1838", "tardy", "Sanderson High");
    }

    @Test
    public void getId() throws Exception {
        assertThat(teacher.getId(), equalTo(2));
    }

    @Test
    public void setId() throws Exception {
        teacher.setId(3);
        assertThat(teacher.getId(), equalTo(2));
    }

    @Test
    public void getFirstName() throws Exception {
        assertThat(teacher.getFirstName(), equalTo("Niki"));
    }

    @Test
    public void setFirstName() throws Exception {
        teacher.setFirstName("Austin");
        assertThat(teacher.getFirstName(), equalTo("Austin"));
    }

    @Test
    public void getLastName() throws Exception {
        assertThat(teacher.getLastName(), equalTo("Cama"));
    }

    @Test
    public void setLastName() throws Exception {
        teacher.setLastName("Crayz");
        assertThat(teacher.getLastName(), equalTo("Crayz"));
    }

    @Test
    public void getEmail() throws Exception {
        assertThat(teacher.getEmail(), equalTo("Niki@gmail.com"));
    }

    @Test
    public void setEmail() throws Exception {
        teacher.setEmail("Austin@gmail.com");
        assertThat(teacher.getEmail(), equalTo("Austin@gmail.com"));
    }

    @Test
    public void getPassword() throws Exception {
        assertThat(teacher.getPassword(), equalTo("qwerty"));
    }

    @Test
    public void setPassword() throws Exception {
        teacher.setPassword("HelloWorld!");
        assertThat(teacher.getPassword(), equalTo("HelloWorld!"));
    }

    @Test
    public void getPhoneNumber() throws Exception {
        assertThat(teacher.getPhoneNumber(), equalTo("919-438-1838"));
    }

    @Test
    public void setPhoneNumber() throws Exception {
        teacher.setPhoneNumber("438-283-8286");
        assertThat(teacher.getPhoneNumber(), equalTo("438-283-8286"));
    }

    @Test
    public void getSubjectArea() throws Exception {
        assertThat(teacher.getSubjectArea(), equalTo("tardy"));
    }

    @Test
    public void setSubjectArea() throws Exception {
        teacher.setSubjectArea("disruptive");
        assertThat(teacher.getSubjectArea(), equalTo("disruptive"));
    }

}