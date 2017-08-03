package com.forestnewark.repository;

import com.forestnewark.bean.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message,Integer> {

    Message findByMessageName(String name);
}
