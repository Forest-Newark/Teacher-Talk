package com.forestnewark.repository;

import com.forestnewark.bean.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ParentRepository extends JpaRepository<Parent, Integer> {

    Parent findByPrimaryEmail(String email);

}
