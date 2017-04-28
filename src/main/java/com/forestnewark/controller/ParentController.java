package com.forestnewark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ParentController {


    @RequestMapping("/parent")
    public String parentSignUp() {
        return "parent";
    }
}