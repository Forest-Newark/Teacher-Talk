package com.forestnewark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cmitchell on 4/28/17.
 */

@Controller
public class StudentController {

    @RequestMapping("/studentSignUp")
    public String studentSignUp() {
        return "studentSignUp";
    }




}
