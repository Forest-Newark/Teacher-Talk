package com.forestnewark.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Log like bean, html page that has a table on it, gets populated with data from log.
 * Form on top of log that lets you search. logservice.save. make another repointerface for log table. in database service need to autowire in logrepo.
 * Created by cmitchell on 5/1/17.
 */
//creating log class for the message log for the teacher to view previous/recent messages that the teacher sent to the parents/guardians regarding the student/child

//this tells JPA that the log class is a JPA entity and can be persisted to a database
@Entity
public class Log {
//using @Id and @GeneratedValue for hibernate.
// @Id this tells JPA that private int id is the primary key.
// @Generated Value this tells JPA that is should automatically generate this key for this entity
    @Id
    @GeneratedValue
    private int id;

    private String messageSentTo;
    private String studentName;
    private String parentName;
    private String templatesent;
    private String notes;

    public Log() {
    }
//setting Contructors
    public Log(String messageSentTo, String studentName, String parentName, String templatesent, String notes) {
        this.messageSentTo = messageSentTo;
        this.studentName = studentName;
        this.parentName = parentName;
        this.templatesent = templatesent;
        this.notes = notes;
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

    public String getTemplatesent() {
        return templatesent;
    }

    public void setTemplatesent(String templatesent) {
        this.templatesent = templatesent;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
