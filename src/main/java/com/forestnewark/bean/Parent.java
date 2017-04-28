package com.forestnewark.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class Parent {

    @Id
    @GeneratedValue
    private int id;

    private String primaryFirstName;
    private String secondaryFirstName;
    private String primaryLastName;
    private String secondaryLastName;
    private String primaryEmail;
    private String secondaryEmail;
    private String password;
    private String phoneNumber;
    private String preferredContactMethod;

    public Parent() {
    }

    public Parent(String primaryFirstName, String secondaryFirstName, String primaryLastName, String secondaryLastName, String primaryEmail, String secondaryEmail, String password, String phoneNumber, String preferredContactMethod) {
        this.primaryFirstName = primaryFirstName;
        this.secondaryFirstName = secondaryFirstName;
        this.primaryLastName = primaryLastName;
        this.secondaryLastName = secondaryLastName;
        this.primaryEmail = primaryEmail;
        this.secondaryEmail = secondaryEmail;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.preferredContactMethod = preferredContactMethod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimaryFirstName() {
        return primaryFirstName;
    }

    public void setPrimaryFirstName(String primaryFirstName) {
        this.primaryFirstName = primaryFirstName;
    }

    public String getSecondaryFirstName() {
        return secondaryFirstName;
    }

    public void setSecondaryFirstName(String secondaryFirstName) {
        this.secondaryFirstName = secondaryFirstName;
    }

    public String getPrimaryLastName() {
        return primaryLastName;
    }

    public void setPrimaryLastName(String primaryLastName) {
        this.primaryLastName = primaryLastName;
    }

    public String getSecondaryLastName() {
        return secondaryLastName;
    }

    public void setSecondaryLastName(String secondaryLastName) {
        this.secondaryLastName = secondaryLastName;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }

    public void setPreferredContactMethod(String preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
    }
}
