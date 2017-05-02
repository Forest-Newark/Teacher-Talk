package com.forestnewark.service;

import com.forestnewark.bean.Message;
import com.forestnewark.bean.Parent;
import com.forestnewark.bean.Student;
import com.forestnewark.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by forestnewark on 4/30/17.
 */
@Component
public class DatabaseService {

    // Autowiring repositories and created parameters for constructor
    final
    ParentRepository parentRepository;

    final
    StudentRepository studentRepository;

    final
    TeacherRepository teacherRepository;

    final
    MessageRepository messageRepository;

    final
    MessageLogRepository messageLogRepository;


    @Autowired
    public DatabaseService(ParentRepository parentRepository, StudentRepository studentRepository, TeacherRepository teacherRepository, MessageRepository messageRepository, MessageLogRepository messageLogRepository) {
        this.parentRepository = parentRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.messageRepository = messageRepository;
        this.messageLogRepository = messageLogRepository;
    }



    public boolean validateUser(String email, String password){

        if(teacherRepository.findByEmail(email).size() > 0){
            if(teacherRepository.findByEmail(email).get(0).getPassword().equals(password)){
                return true;
            }
        }

        else if(parentRepository.findByPrimaryEmail(email) != null){
            if(parentRepository.findByPrimaryEmail(email).getPassword().equals(password)){
                return true;
            }
        }

        return false;
    }

    public String userType(String loginEmail){
        if(teacherRepository.findByEmail(loginEmail).size() > 0){
            return "teacher";
        }

        if(parentRepository.findByPrimaryEmail(loginEmail) != null) {
            return "parent";
        }

        return null;
    }


    public String getUserPassword(String loginEmail) {

        if(userType(loginEmail).equals("teacher")){
           return teacherRepository.findByEmail(loginEmail).get(0).getPassword();
        }else {
            return parentRepository.findByPrimaryEmail(loginEmail).getPassword();
        }

    }


    public Parent parentByPrimaryEmail(String userEmail) {
        return parentRepository.findByPrimaryEmail(userEmail);

    }

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public List<Message> getAllMessages() {

        return messageRepository.findAll();
    }

    public Student getStudentById(String studentId) {

        return studentRepository.getOne(Integer.parseInt(studentId));
    }

    public Message getMessageByName(String messageName) {

        return messageRepository.findByMessageName(messageName);
    }
}
