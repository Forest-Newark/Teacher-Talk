package com.forestnewark.bean;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

/**
 * Log bean, html page that has a table on it, gets populated with data from log.
 * Form on top of log that lets you search.
 */

/**
 * creating log class for the message log for the teacher to view previous/recent messages
 * that the teacher sent to the parents/guardians regarding the student/child
 */


//this tells JPA that the log class is a JPA entity and can be persisted to a database in Hibernate

@Entity
@Proxy(lazy=false)
@Transactional
public class Log {
//using @Id and @GeneratedValue for hibernate.
// @Id tells JPA that private int id is the primary key.
// @Generated Value tells JPA that is should automatically generate this key for this entity

    @Id
    @GeneratedValue
    private Integer id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    private String studentName;
    private String parentName;
    private String templateSent;
    private String sentBy;



    public Log() {
    }

    public Log(String studentName, Date created, String parentName, String templateSent, String sentBy) {

        this.studentName = studentName;
        this.parentName = parentName;
        this.templateSent = templateSent;
        this.sentBy = sentBy;
        this.created = created;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getTemplateSent() {
        return templateSent;
    }

    public void setTemplateSent(String templateSent) {
        this.templateSent = templateSent;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String notes) {
        this.sentBy = sentBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
