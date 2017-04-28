package com.forestnewark.repository;

import com.forestnewark.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cmitchell on 4/28/17.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
