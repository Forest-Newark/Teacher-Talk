package com.forestnewark.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by forestnewark on 5/1/17.
 */

@Entity
public class Message {

    @Id
    @GeneratedValue
    private int id;

    private String messageName;
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
