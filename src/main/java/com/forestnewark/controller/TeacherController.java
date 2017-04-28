package com.forestnewark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {

    @RequestMapping("/teacherSignUp")
    public String teacherSignUp(){
        return "teacherSignUp";
    }

    @RequestMapping("/teacher")
    public String teacher(){
        return "teacher";
    }
}
