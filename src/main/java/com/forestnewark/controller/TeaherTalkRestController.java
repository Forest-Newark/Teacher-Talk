package com.forestnewark.controller;

import com.forestnewark.bean.Student;
import com.forestnewark.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by forestnewark on 5/3/17.
 */

@RestController
public class TeaherTalkRestController {

    @Autowired
    DatabaseService ds;

    @RequestMapping("/getAllStudents")
    public List<Student> getAllStudents(){

        return ds.getAllStudents();

    }



}
