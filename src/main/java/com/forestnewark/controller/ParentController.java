package com.forestnewark.controller;

import com.forestnewark.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ParentController {

    @RequestMapping("/parentSignUp")
    public String parentSignUp() {
        return "parentSignUp";
    }
}
