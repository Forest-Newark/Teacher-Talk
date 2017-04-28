package com.forestnewark.service;

import com.forestnewark.repository.ParentRepository;
import com.forestnewark.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginService {

    final
    ParentRepository parentRepository;

    final
    TeacherRepository teacherRepository;

    @Autowired
    public LoginService(ParentRepository parentRepository, TeacherRepository teacherRepository) {
        this.parentRepository = parentRepository;
        this.teacherRepository = teacherRepository;
    }

    public boolean validateUser(String email, String password){

        if(teacherRepository.findByEmail(email).size() > 0){
            if(teacherRepository.findByEmail(email).get(0).getPassword().equals(password)){
                return true;
            }
        }

        else if(parentRepository.findByPrimaryEmail(email).size() >0){
            if(parentRepository.findByPrimaryEmail(email).get(0).getPassword().equals(password)){
                return true;
            }
        }

        return false;
    }

    public String userType(String loginEmail){
        if(teacherRepository.findByEmail(loginEmail).size() > 0){
            return "teacher";
        }

        if(parentRepository.findByPrimaryEmail(loginEmail).size() >0) {
            return "parent";
        }

        return null;
    }


}
