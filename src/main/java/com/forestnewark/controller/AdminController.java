package com.forestnewark.controller;

import com.forestnewark.repository.MessageRepository;
import com.forestnewark.repository.ParentRepository;
import com.forestnewark.repository.StudentRepository;
import com.forestnewark.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by forestnewark on 5/11/17.
 */
@Controller
public class AdminController {
    final
    MessageRepository messageRepository;

    final
    StudentRepository studentRepository;

    final
    ParentRepository parentRepository;

    final
    TeacherRepository teacherRepository;

    @Autowired
    public AdminController(MessageRepository messageRepository, StudentRepository studentRepository, ParentRepository parentRepository, TeacherRepository teacherRepository) {
        this.messageRepository = messageRepository;
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
        this.teacherRepository = teacherRepository;
    }


    @RequestMapping("/adminpage")
    public String adminPage(ModelMap model) {
        model.addAttribute("messages",messageRepository.findAll());
        model.addAttribute("students",studentRepository.findAll());
        model.addAttribute("parents",parentRepository.findAll());
        model.addAttribute("teachers",teacherRepository.findAll());
        return "adminpage";

    }

    @RequestMapping("/deleteMessage")
    public RedirectView deleteMessage(Integer messageId){

        messageRepository.delete(messageId);
        return new RedirectView("/adminpage");
    }

    @RequestMapping("/deleteStudent")
    public RedirectView deleteStudent(Integer studentId){

        studentRepository.delete(studentId);
        return new RedirectView("/adminpage");
    }

    @RequestMapping("/deleteParent")
    public RedirectView deleteParent(Integer parentId){
        parentRepository.delete(parentId);
        return new RedirectView("/adminpage");
    }

    @RequestMapping("/deleteTeacher")
    public RedirectView deleteTeacher(Integer teacherId){
        teacherRepository.delete(teacherId);
        return new RedirectView("/adminpage");
    }
}
