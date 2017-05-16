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


    //GENERAL USER METHODS (PARENT & TEACHERS)

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
     * Get the Id of a specific user by their Email Address
     *
     * @param email of user to be found
     * @return integer value of user ID
     */
    public Integer getUserIdByEmail(String email) {
        if (this.userType(email).equals("teacher")) {
            return this.getTeacherByEmail(email).getId();
        }

        if (this.userType(email).equals("parent")) {
            return this.parentByPrimaryEmail(email).getId();

        } else {
            return null;
        }
    }


    /**
     * Update user password using their ID
     *
     * @param password create a new password
     * @param userId   using user's ID
     */
    public void updateUserPasswordById(Integer userId,String password, String email) {

        // if user ID matches teacher, then sets password for teacher
        if(this.userType(email).equals("teacher")) {

            Teacher teacher = teacherRepository.getOne(userId);

            teacher.setPassword(password);

            teacherRepository.save(teacher);
        }


        // if user ID matches parent, then sets password for parent
        else if (this.userType(email).equals("parent")){
            Parent parent = parentRepository.getOne(userId);
            parent.setPassword(password);
            parentRepository.save(parent);
        }
    }


    //PARENT METHODS


    /**
     * Finds a parent user by their primary email address
     *
     * @param userEmail of the parent to be found
     * @return parent with the provided email
     */
    public Parent parentByPrimaryEmail(String userEmail) {
        return parentRepository.findByPrimaryEmail(userEmail);

    }


    //TEACHER METHODS

    /**
     * Find a TEACHER by their email address
     *
     * @param email of teacer to be found
     * @return teacher with the provided email address
     */
    public Teacher getTeacherByEmail(String email) {
        return teacherRepository.findByEmail(email);
    }


    //STUDENT METHODS


    /**
     * Generates a list of all Students in the database
     *
     * @return list of Students
     */
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
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


    //MESSAGE METHODS

    /**
     * Generates a list of all Messages in the database
     *
     * @return list of Messages
     */
    public List<Message> getAllMessages() {

        return messageRepository.findAll();
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


    //MESSAGELOG METHODS


    /**
     * Get All Message Log Items
     *
     * @return list of log items
     */
    public List<Log> getAllLog() {
        return messageLogRepository.findAll();
    }


    /**
     * Get Log Items ordered by ID ASCENDING
     *
     * @return list of log items
     */
    public List<Log> getAllLogOrderById() {

        return messageLogRepository.findAllByOrderById();
    }


    /**
     * Get Log Item Order By Student Name
     *
     * @return list of log items
     */
    public List<Log> getAllLogOrderByStudentName() {
        return messageLogRepository.findAllByOrderByStudentName();

    }


    /**
     * Get Log Items Order By Parent Name
     *
     * @return list of log items
     */
    public List<Log> getAllLogOrderByParentName() {
        return messageLogRepository.findAllByOrderByParentName();
    }


    /**
     * Get Log Item Order By Template Name
     *
     * @return list of log items
     */
    public List<Log> getAllLogOrderByTemplateSent() {
        return messageLogRepository.findAllByOrderByTemplateSent();
    }

    /**
     * Get Log Item Order By Notes
     *
     * @return list of log items
     */
    public List<Log> getAllLogOrderBySentBy() {
        return messageLogRepository.findAllByOrderBySentBy();
    }


    public List<Log> getAllLogOrderByCreated() {

            return messageLogRepository.findAllByOrderByCreated();
    }


    public List<Log> messageLogSearch(String search){

        return messageLogRepository.findByStudentNameIgnoreCaseContainingOrParentNameIgnoreCaseContainingOrTemplateSentIgnoreCaseContainingOrSentByIgnoreCaseContaining(search,search,search,search);
    }

    public void saveNewLog(Log log){
        messageLogRepository.saveAndFlush(log);
    }


    public void saveTeacher(Teacher teacher) {

        teacherRepository.save(teacher);
    }

    public void saveParent(Parent parent) {

        parentRepository.save(parent);
    }

    public void saveStudent(Student student) {

        studentRepository.save(student);
    }

    public void saveMessage(String templateName, String templateBody) {

        messageRepository.save(new Message(templateName,templateBody));

    }

    public List<Message> getAllTemplates() {
        return messageRepository.findAll();
    }
}

