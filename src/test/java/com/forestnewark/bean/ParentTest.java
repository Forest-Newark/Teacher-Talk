package com.forestnewark.bean;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by forestnewark on 4/29/17.
 */
public class ParentTest {

    private Parent parent;

    /*
    Set up Parent Object to test against
     */
    @Before
    public void setUp(){
        parent = new Parent("Frank","Suzie","Jones","Jones","frank@gmail.com","suzie@gmail.com","password123","919-568-3091","both");
    }


    @Test
    public void parentConstructorCreatesParent() {
        assertThat(parent,notNullValue());

    }


    @Test
    public void getId() throws Exception {



    }


    @Test
    public void setId() throws Exception {

    }

    @Test
    public void getPrimaryFirstName() throws Exception {

        assertThat(parent.getPrimaryEmail(),equalTo("frank@gmail.com"));

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

    }

    @Test
    public void getPrimaryLastName() throws Exception {

    }

    @Test
    public void setPrimaryLastName() throws Exception {

    }

    @Test
    public void getSecondaryLastName() throws Exception {

    }

    @Test
    public void setSecondaryLastName() throws Exception {

    }

    @Test
    public void getPrimaryEmail() throws Exception {

    }

    @Test
    public void setPrimaryEmail() throws Exception {

    }

    @Test
    public void getSecondaryEmail() throws Exception {

    }

    @Test
    public void setSecondaryEmail() throws Exception {

    }

    @Test
    public void getPassword() throws Exception {

    }

    @Test
    public void setPassword() throws Exception {

    }

    @Test
    public void getPhoneNumber() throws Exception {

    }

    @Test
    public void setPhoneNumber() throws Exception {

    }

    @Test
    public void getPreferredContactMethod() throws Exception {

    }

    @Test
    public void setPreferredContactMethod() throws Exception {

    }

}