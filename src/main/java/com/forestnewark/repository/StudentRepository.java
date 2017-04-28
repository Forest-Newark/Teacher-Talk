package com.forestnewark.repository;

import com.forestnewark.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
}
