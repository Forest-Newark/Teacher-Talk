package com.forestnewark.repository;

import com.forestnewark.bean.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cmitchell on 4/28/17.
 */
public interface ParentRepository extends JpaRepository<Parent, Integer> {
}
