package com.forestnewark.bean;

import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
@Proxy(lazy=false)
public class Message {

    @Id
    @GeneratedValue
    private int id;

    private String messageName;

    @Column(columnDefinition="TEXT")
    private String englishMessage;

    public Message() {
    }

    public Message(String messageName, String englishMessage) {
        this.messageName = messageName;
        this.englishMessage = englishMessage;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getEnglishMessage() {
        return englishMessage;
    }

    public void setEnglishMessage(String englishMessage) {
        this.englishMessage = englishMessage;
    }
}
