package com.forestnewark.service;

import com.forestnewark.bean.Log;
import com.forestnewark.bean.Student;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * Created by Forest Newark on 5/1/17. This class is responsible for generating
 * and sending messages to the appropriate recipients
 */
@Service
@EnableAsync
public class MessageService {

    private final DatabaseService ds;

    final
    TranslationService ts;


    private final String username = "teacher.talk.tiy@gmail.com";
    private final String password = "tiyteachertalk";


    @Autowired
    public MessageService(DatabaseService ds, TranslationService ts) {
        this.ds = ds;
        this.ts = ts;
    }


    /**
     * Sends an email to a the primary email of a parent based on student id.
     * @param studentId of the student who will recieve the message
     * @param messageName for the template of the message to be sent
     */
    @Async
    public void sendMessage(String studentId, String messageName, String currentUserEmail, String messageText) {
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
            message.setText(this.messageBuilder(studentId,messageName,currentUserEmail,messageText)); // Body Text

            Transport.send(message);

            Student student = ds.getStudentById(studentId);
            Log newLog = new Log(student.getStudentFirstName() + " " + student.getStudentLastName(),null,student.getParent().getPrimaryFirstName() + " " + student.getParent().getPrimaryLastName(),messageName,ds.getTeacherByEmail(currentUserEmail).getFirstName() +" "+ ds.getTeacherByEmail(currentUserEmail).getLastName());
            ds.saveNewLog(newLog);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public String messageBuilder(String studentId, String messageName,String currentUserEmail, String messageText){

        StringBuilder sb = new StringBuilder();
        sb.append("To the Parent(s) or Guardian(s) of: ");
        sb.append(ds.getStudentById(studentId).getStudentFirstName() +" " +ds.getStudentById(studentId).getStudentLastName());
        sb.append("\n\n");
           sb.append(messageText);

        if(ds.getStudentById(studentId).getParent().getPreferredLanguage().equals("spanish")){
                sb.append("\n\n");
                sb.append(ts.translationMessage("The following is an automatic translation of the above message","es","en"));
                sb.append("\n");
                sb.append(ts.translationMessage(messageText,"es","en"));
        }
        sb.append("\n\n");
        sb.append("Respectfully, \n");
        sb.append(WordUtils.capitalize(ds.getTeacherByEmail(currentUserEmail).getFirstName()) + " " + WordUtils.capitalize(ds.getTeacherByEmail(currentUserEmail).getLastName()));
        sb.append("\nMessage Created by Teacher-Talk");

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
                    "http://localhost:8080/resetPassword?userId="+userId+"&email="+email);


            Transport.send(message);

            System.out.println("Message Sent!"); //Confirmation Method - Not necessary

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public void sendParentSignUpNotification(String parentEmail) {
        System.out.println("This should send an email....");
    }
}

