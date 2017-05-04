package com.forestnewark.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Log bean, html page that has a table on it, gets populated with data from log.
 * Form on top of log that lets you search.
 */

//creating log class for the message log for the teacher to view previous/recent messages that the teacher sent to the parents/guardians regarding the student/child

//this tells JPA that the log class is a JPA entity and can be persisted to a database
@Entity
public class Log {
//using @Id and @GeneratedValue for hibernate.
// @Id tells JPA that private int id is the primary key.
// @Generated Value tells JPA that is should automatically generate this key for this entity
    @Id
    @GeneratedValue
    private int id;

    private String messageSentTo;
    private String localDate;
    private String studentName;
    private String parentName;
    private String templateSent;
    private String notes;

    public Log() {
    }
//setting Contructors
    public Log(String messageSentTo, String studentName, String localDate,String parentName, String templateSent, String notes) {
        this.messageSentTo = messageSentTo;
        this.studentName = studentName;
        this.parentName = parentName;
        this.templateSent = templateSent;
        this.notes = notes;
        this.localDate = localDate;

    }
//setting getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageSentTo() {
        return messageSentTo;
    }

    public void setMessageSentTo(String messageSentTo) {
        this.messageSentTo = messageSentTo;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }
}
