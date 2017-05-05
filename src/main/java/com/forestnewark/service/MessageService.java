package com.forestnewark.service;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;


/**
 * Created by Forest Newark on 5/1/17. This class is responsible for generating
 * and sending messages to the appropriate recipients
 */
@Component
public class MessageService {

    private final DatabaseService ds;


    private final String username = "teacher.talk.tiy@gmail.com";
    private final String password = "tiyteachertalk";


    @Autowired
    public MessageService(DatabaseService ds) {
        this.ds = ds;
    }


    /**
     * Sends an email to a the primary email of a parent based on student id.
     * @param studentId of the student who will recieve the message
     * @param messageName for the template of the message to be sent
     */
    public void sendMessage(String studentId, String messageName, String currentUserEmail) {
        System.out.println("I made it send message ms");
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); //Sender's Email Address (FROM)
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(ds.getStudentById(studentId).getParent().getPrimaryEmail())); //Receiver's Email Address (TO)
            message.setSubject("Teacher Talk Test: Student Name: " + ds.getStudentById(studentId).getStudentFirstName()); // Subject Line
            message.setText(this.messageBuilder(studentId,messageName,currentUserEmail)); // Body Text

            Transport.send(message);

            System.out.println("Message Sent!"); //Confirmation Method - Not necessary

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public String messageBuilder(String studentId, String messageName,String currentUserEmail){

        StringBuilder sb = new StringBuilder();
        sb.append("To the Parent(s) or Guardian(s) of: ");
        sb.append(ds.getStudentById(studentId).getStudentFirstName() +" " +ds.getStudentById(studentId).getStudentLastName());
        sb.append("\n\n");
        if(ds.getStudentById(studentId).getParent().getPreferredLanguage().equals("english")){
           sb.append(ds.getMessageByName(messageName).getEnglishMessage());
        }
        if(ds.getStudentById(studentId).getParent().getPreferredLanguage().equals("spanish")){
            sb.append(ds.getMessageByName(messageName).getSpanishMessage());
        }
        sb.append("\n\n");
        sb.append("Respectfully, \n");
        sb.append(WordUtils.capitalize(ds.getTeacherByEmail(currentUserEmail).getFirstName()) + " " + WordUtils.capitalize(ds.getTeacherByEmail(currentUserEmail).getLastName()));

        return sb.toString();

    }



    public void sendPasswordResetEmail(Integer userId, String email) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username)); //Sender's Email Address (FROM)
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email)); //Receiver's Email Address (TO)
            message.setSubject("Teacher Talk Password Reset "); // Subject Line

            message.setText("Dear User,\n You can reset your password at the following address\n" +
                    "http://localhost:8080/resetPassword?userId="+userId);


            Transport.send(message);

            System.out.println("Message Sent!"); //Confirmation Method - Not necessary

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
