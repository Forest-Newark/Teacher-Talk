package com.forestnewark.controller;

import com.forestnewark.bean.Message;
import com.forestnewark.bean.Parent;
import com.forestnewark.bean.Student;
import com.forestnewark.bean.Teacher;
import com.forestnewark.service.DatabaseService;
import com.forestnewark.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by forestnewark on 5/3/17.
 */

@RestController
public class TeacherTalkRestController {

    @Autowired
    DatabaseService ds;

    @Autowired
    MessageService ms;

    @RequestMapping("/getAllStudents")
    public List<Student> getAllStudents(){

        return ds.getAllStudents();

    }


    @PostMapping("/teacherAddStudent")
    public void teacherAddStudent(@RequestParam("studentFirstName") String studentFirstName,@RequestParam("studentLastName") String studentLastName,
    @RequestParam("parentFirstName")String parentFirstName,@RequestParam("parentLastName") String parentLastName,
    @RequestParam("parentEmail")String parentEmail){

        Parent parent = new Parent(parentFirstName,"",parentLastName,"",parentEmail,"","passwordHere","","email","english");
        Student student = new Student(studentFirstName,studentLastName,"","","",parent);

        ds.saveParent(parent);
        ds.saveStudent(student);

        ms.sendParentSignUpNotification(parentEmail);

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

    @PostMapping("/teacherAddTemplate")
    public void teacherAddTemplate(@RequestParam("templateName")String templateName,@RequestParam("templateBody") String templateBody){

        ds.saveMessage(templateName,templateBody);
    }

    @GetMapping("/getAllMessageTemplates")
    public List<Message> getAllTemplates(){

        return ds.getAllTemplates();
    }



}
