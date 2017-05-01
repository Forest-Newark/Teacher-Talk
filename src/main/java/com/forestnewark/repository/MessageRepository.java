package com.forestnewark.repository;

import com.forestnewark.bean.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by forestnewark on 5/1/17.
 */
public interface MessageRepository extends JpaRepository<Message,Integer> {

}
