package com.forestnewark.service;

import com.forestnewark.bean.*;
import com.forestnewark.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Forest Newark on 4/30/17. This class is responsible for managing
 * connections with the database and performing functions with individual
 * repositories
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


    /**
     * Constructor for DatabaseService
     *
     * @param parentRepository     connects to parent repository
     * @param studentRepository    connects to student repository
     * @param teacherRepository    connects to teacher repository
     * @param messageRepository    connects to message repository
     * @param messageLogRepository connects to message log repository
     */
    @Autowired
    public DatabaseService(ParentRepository parentRepository, StudentRepository studentRepository, TeacherRepository teacherRepository, MessageRepository messageRepository, MessageLogRepository messageLogRepository) {
        this.parentRepository = parentRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.messageRepository = messageRepository;
        this.messageLogRepository = messageLogRepository;
    }


    /**
     * Checks that a user has supplied a valid username and password combination
     *
     * @param email    to be checked
     * @param password to be checked
     * @return boolean indicating validity of username and password combination
     */
    public boolean validateUser(String email, String password) {

        if (teacherRepository.findAllByEmail(email).size() > 0) {
            if (teacherRepository.findAllByEmail(email).get(0).getPassword().equals(password)) {
                return true;
            }
        } else if (parentRepository.findByPrimaryEmail(email) != null) {
            if (parentRepository.findByPrimaryEmail(email).getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks to see if a valid user holds a teacher or parent account
     *
     * @param loginEmail of a valid user
     * @return the type of account the user holds
     */
    public String userType(String loginEmail) {
        if (teacherRepository.findAllByEmail(loginEmail).size() > 0) {
            return "teacher";
        }

        if (parentRepository.findByPrimaryEmail(loginEmail) != null) {
            return "parent";
        }

        return null;
    }

    /**
     * Gets the password of a specific user
     *
     * @param loginEmail of the user to retrieve password
     * @return the password of the user
     */
    public String getUserPassword(String loginEmail) {

        if (userType(loginEmail).equals("teacher")) {
            return teacherRepository.findAllByEmail(loginEmail).get(0).getPassword();
        } else {
            return parentRepository.findByPrimaryEmail(loginEmail).getPassword();
        }

    }

    /**
     * Finds a parent user by their primary email address
     *
     * @param userEmail of the parent to be found
     * @return parent with the provided email
     */
    public Parent parentByPrimaryEmail(String userEmail) {
        return parentRepository.findByPrimaryEmail(userEmail);

    }


    /**
     * Generates a list of all Students in the database
     *
     * @return list of Students
     */
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    /**
     * Generates a list of all Messages in the database
     *
     * @return list of Messages
     */
    public List<Message> getAllMessages() {

        return messageRepository.findAll();
    }

    /**
     * Finds a student based on the studentId
     *
     * @param studentId of the student
     * @return Student with the provided id
     */
    public Student getStudentById(String studentId) {

        return studentRepository.getOne(Integer.parseInt(studentId));
    }


    /**
     * Find a message based on its name
     *
     * @param messageName of the message
     * @return the message with the provided messageName
     */
    public Message getMessageByName(String messageName) {

        return messageRepository.findByMessageName(messageName);
    }

    public List<Log> getAllMessagesOrderById() {
        return messageLogRepository.findAll();

    }

    public List<Log> getAllLog() {
        return messageLogRepository.findAll();
    }

    public List<Log> getAllLogIdDesc(){
        return messageLogRepository.findAllByOrderById();
    }

    public List<Log> getAllLogOrderById() {

        return messageLogRepository.findAllByOrderById();
    }

    public List<Log> getAllLogOrderByStudentName() {
        return messageLogRepository.findAllByOrderByStudentName();

    }


    public List<Log> getAllLogOrderByParentName() {
        return messageLogRepository.findAllByOrderByParentName();
    }



    public Integer getUserIdByEmail(String email) {
        if (this.userType(email).equals("teacher")){
            return this.getTeacherByEmail(email).getId();
        }

        if (this.userType(email).equals("parent")) {
            return this.parentByPrimaryEmail(email).getId();

        }
        else {
            return null;
        }
    }

    private Teacher getTeacherByEmail(String email) {
        return teacherRepository.findByEmail(email);
    }

    public List<Log> getAllLogOrderByTemplateSent() {
        return messageLogRepository.findAllByOrderByTemplateSent();
    }

    public List<Log> getAllLogOrderByNotes() {
        return messageLogRepository.findAllByOrderByNotes();
    }

    public List<Log> getAllLogOrderByLocalDate() {
        return messageLogRepository.findAllByOrderByLocalDate();
    }

}
