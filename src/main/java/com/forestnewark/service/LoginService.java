package com.forestnewark.service;

import org.springframework.stereotype.Component;


@Component
public class LoginService {


    public boolean validateUser(String username, String password){

        return true;
    }

    public String userType(String loginEmail){

        return "teacher";
    }


}
