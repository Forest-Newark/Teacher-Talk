package com.forestnewark.bean;


public class MessageTranslation {

    private String text;
    private String from;
    private String to;
    private String translationText;



    public MessageTranslation(){}

    public MessageTranslation(String text, String from, String to, String translationText) {
        this.text = text;
        this.from = from;
        this.to = to;
        this.translationText = translationText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTranslationText() {
        return translationText;
    }

    public void setTranslationText(String translationText) {
        this.translationText = translationText;
    }
}
