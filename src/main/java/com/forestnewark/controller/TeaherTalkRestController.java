package com.forestnewark.controller;

import com.forestnewark.bean.Student;
import com.forestnewark.bean.Teacher;
import com.forestnewark.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/teacherAddStudent")
    public void teacherAddStudent(@RequestParam("studentFirstName") String studentFirstName){
        System.out.println(studentFirstName);

    }

    @PostMapping("/teacherUpdateInfo")
    public void teacherUpdateInfo(Teacher teacher){

        Teacher updateTeacher= ds.getTeacherByEmail(teacher.getEmail());

        System.out.println(updateTeacher.getId());

        updateTeacher.setFirstName(teacher.getFirstName());
        updateTeacher.setLastName(teacher.getLastName());
        updateTeacher.setPassword(teacher.getPassword());
        updateTeacher.setPhoneNumber(teacher.getPhoneNumber());
        updateTeacher.setSchoolName(teacher.getSchoolName());
        updateTeacher.setSubjectArea(teacher.getSubjectArea());

        ds.saveTeacher(updateTeacher);
    }



}
