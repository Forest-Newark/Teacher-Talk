package com.forestnewark.bean;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;


public class ParentTest {

    private Parent parent;

    /*
    Set up Parent Object to test against
     */
    @Before
    public void setUp(){
        parent = new Parent("Frank","Suzie","Jones","Jones","frank@gmail.com","suzie@gmail.com","password123","919-568-3091","both", "english");

    }


    @Test
    public void parentConstructorCreatesParent() {
        assertThat(parent,notNullValue());

    }


    @Test
    public void getId() throws Exception {
        assertThat(parent.getId(), equalTo(1));

    }


    @Test
    public void setId() throws Exception {
        parent.setId(5);
        assertThat(parent.getId(), equalTo(5));
    }

    @Test
    public void getPrimaryFirstName() throws Exception {
        assertThat(parent.getPrimaryFirstName(),equalTo("Frank"));

    }

    @Test
    public void setPrimaryFirstName() throws Exception {
        parent.setPrimaryFirstName("Jim");
        assertThat(parent.getPrimaryFirstName(),equalTo("Jim"));

    }

    @Test
    public void getSecondaryFirstName() throws Exception {
        assertThat(parent.getSecondaryFirstName(),equalTo("Suzie"));

    }

    @Test
    public void setSecondaryFirstName() throws Exception {
        parent.setSecondaryFirstName("Felicia");
        assertThat(parent.getSecondaryFirstName(),equalTo("Felicia"));

    }

    @Test
    public void getPrimaryLastName() throws Exception {
        assertThat(parent.getPrimaryLastName(),equalTo("Jones"));

    }

    @Test
    public void setPrimaryLastName() throws Exception {
        parent.setPrimaryLastName("Poling");
        assertThat(parent.getPrimaryLastName(),equalTo("Poling"));
    }

    @Test
    public void getSecondaryLastName() throws Exception {
        assertThat(parent.getSecondaryLastName(),equalTo("Jones"));
    }

    @Test
    public void setSecondaryLastName() throws Exception {
        parent.setSecondaryLastName("Katz");
        assertThat(parent.getSecondaryLastName(),equalTo("Katz"));
    }

    @Test
    public void getPrimaryEmail() throws Exception {
        assertThat(parent.getPrimaryEmail(), equalTo("frank@gmail.com"));
    }

    @Test
    public void setPrimaryEmail() throws Exception {
        parent.setPrimaryEmail("ColeKatz@gmail.com");
        assertThat(parent.getPrimaryEmail(), equalTo("ColeKatz@gmail.com"));
    }

    @Test
    public void getSecondaryEmail() throws Exception {
        assertThat(parent.getSecondaryEmail(), equalTo("suzie@gmail.com"));
    }

    @Test
    public void setSecondaryEmail() throws Exception {
        parent.setSecondaryEmail("JenKatz@gmail.com");
        assertThat(parent.getSecondaryEmail(), equalTo("JenKatz@gmail.com"));
    }

    @Test
    public void getPassword() throws Exception {
        assertThat(parent.getPassword(), equalTo("password123"));
    }

    @Test
    public void setPassword() throws Exception {
        parent.setPassword("qwerty");
        assertThat(parent.getPassword(), equalTo("qwerty"));
    }

    @Test
    public void getPhoneNumber() throws Exception {
        assertThat(parent.getPhoneNumber(), equalTo("919-568-3091"));
    }

    @Test
    public void setPhoneNumber() throws Exception {
        parent.setPhoneNumber("919-482-1938");
        assertThat(parent.getPhoneNumber(), equalTo("919-482-1938"));
    }

    @Test
    public void getPreferredContactMethod() throws Exception {
        assertThat(parent.getPreferredContactMethod(), equalTo("both"));
    }

    @Test
    public void setPreferredContactMethod() throws Exception {
        parent.setPreferredContactMethod("text");
        assertThat(parent.getPreferredContactMethod(), equalTo("text"));
    }

}