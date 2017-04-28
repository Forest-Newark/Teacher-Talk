package com.forestnewark.service;

import com.forestnewark.bean.Student;
import com.forestnewark.repository.ParentRepository;
import com.forestnewark.repository.StudentRepository;
import com.forestnewark.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DatabaseService {

    final
    ParentRepository parentRepository;

    final
    StudentRepository studentRepository;

    final
    TeacherRepository teacherRepository;

    @Autowired
    public DatabaseService(ParentRepository parentRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.parentRepository = parentRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }
}
