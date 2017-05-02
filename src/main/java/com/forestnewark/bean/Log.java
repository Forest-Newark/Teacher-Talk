package com.forestnewark.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Log like bean, html page that has a table on it, gets populated with data from log.
 * Form on top of log that lets you search. logservice.save. make another repointerface for log table. in database service need to autowire in logrepo.
 * Created by cmitchell on 5/1/17.
 */

@Entity
public class Log {

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

    public Log(String messageSentTo, String studentName, String parentName, String templatesent, String notes) {
        this.messageSentTo = messageSentTo;
        this.studentName = studentName;
        this.parentName = parentName;
        this.templatesent = templatesent;
        this.notes = notes;
    }

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
