package com.forestnewark.bean;

import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//created Parent class added Entity for hibernate to persist data


@Entity
@Proxy(lazy = false)
public class Parent {
    //@ID is setting the primary key which is private int id.
    //@Generated Value is telling JPA that it should automatically generate the key for this entity(private int id
    //@Id this tells JPA that private int id is the primary key for this entity.
// @GeneratedValue this tells JPA that JPA should automatically generate this key for the entity
    @Id
    @GeneratedValue
    private int id;

    private String primaryFirstName;
    private String secondaryFirstName;
    private String primaryLastName;
    private String secondaryLastName;
    @Column(name = "primay_email", unique=true)
    private String primaryEmail;
    private String secondaryEmail;
    private String password;
    private String phoneNumber;
    private String preferredContactMethod;
    private String preferredLanguage;

    public Parent() {
    }

//    public Parent(String primaryFirstName, String secondaryFirstName, String primaryLastName, String secondaryLastName, String primaryEmail, String secondaryEmail, String password, String phoneNumber) {
//        this.primaryFirstName = primaryFirstName;
//        this.secondaryFirstName = secondaryFirstName;
//        this.primaryLastName = primaryLastName;
//        this.secondaryLastName = secondaryLastName;
//        this.primaryEmail = primaryEmail;
//        this.secondaryEmail = secondaryEmail;
//        this.password = password;
//        this.phoneNumber = phoneNumber;
//    }

    public Parent(String primaryFirstName, String secondaryFirstName, String primaryLastName, String secondaryLastName, String primaryEmail, String secondaryEmail, String password, String phoneNumber, String preferredContactMethod, String preferredLanguage) {
        this.primaryFirstName = primaryFirstName;
        this.secondaryFirstName = secondaryFirstName;
        this.primaryLastName = primaryLastName;
        this.secondaryLastName = secondaryLastName;
        this.primaryEmail = primaryEmail;
        this.secondaryEmail = secondaryEmail;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.preferredContactMethod = preferredContactMethod;
        this.preferredLanguage = preferredLanguage;
    }


    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getPrimaryFirstName() {
        return primaryFirstName;
    }

    void setPrimaryFirstName(String primaryFirstName) {
        this.primaryFirstName = primaryFirstName;
    }

    public String getSecondaryFirstName() {
        return secondaryFirstName;
    }

    void setSecondaryFirstName(String secondaryFirstName) {
        this.secondaryFirstName = secondaryFirstName;
    }

    public String getPrimaryLastName() {
        return primaryLastName;
    }

    void setPrimaryLastName(String primaryLastName) {
        this.primaryLastName = primaryLastName;
    }

    public String getSecondaryLastName() {
        return secondaryLastName;
    }

    void setSecondaryLastName(String secondaryLastName) {
        this.secondaryLastName = secondaryLastName;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    void setSecondaryEmail(String secondaryEmail) {
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

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }

    void setPreferredContactMethod(String preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }


}
