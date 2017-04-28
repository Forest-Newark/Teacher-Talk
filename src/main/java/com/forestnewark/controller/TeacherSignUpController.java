package com.forestnewark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherSignUpController {

    @RequestMapping("/teacherSignUp")
    public String teacherSignUp (){
        return "teacherSignUp";
    }
}
