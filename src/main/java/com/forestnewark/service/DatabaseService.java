package com.forestnewark.service;

import com.forestnewark.bean.Parent;
import com.forestnewark.bean.Student;
import com.forestnewark.repository.ParentRepository;
import com.forestnewark.repository.StudentRepository;
import com.forestnewark.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by forestnewark on 4/30/17.
 */
@Component
public class DatabaseService {

    final
    ParentRepository parentRepository;

    final
    StudentRepository studentRepository;

    final
    TeacherRepository teacherRepository;


    @Autowired
    public DatabaseService(ParentRepository parentRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.parentRepository = parentRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
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
}
