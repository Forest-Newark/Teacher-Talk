package com.forestnewark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;



/**
 * Created by forestnewark on 5/1/17.
 */
@Component
public class MessageService {

    private final DatabaseService ds;

    final String username = "teacher.talk.tiy@gmail.com";
    final String password = "tiyteachertalk";

    @Autowired
    public MessageService(DatabaseService ds) {
        this.ds = ds;
    }


    public void sendMessage(String studentId, String messageName) {

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
            message.setText(ds.getMessageByName(messageName).getEnglishMessage()); // Body Text

            Transport.send(message);

            System.out.println("Message Sent!"); //Confirmation Method - Not necessary

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
