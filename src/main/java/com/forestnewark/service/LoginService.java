package com.forestnewark.service;

import org.springframework.stereotype.Component;

/**
 * Created by forestnewark on 4/28/17.
 */
@Component
public class LoginService {


    public boolean validateUser(String username, String password){

        return true;
    }

    public String userType(String loginEmail){

        return "teacher";
    }


}
