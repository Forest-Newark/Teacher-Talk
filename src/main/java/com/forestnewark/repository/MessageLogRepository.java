package com.forestnewark.repository;

import com.forestnewark.bean.Log;
import com.forestnewark.bean.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cmitchell on 5/1/17.
 */
public interface MessageLogRepository extends JpaRepository<Log, Integer>{
//    List<Log> findAllOrderById();
//
//    List<Log> findAllOrderByParentNameDec();
}
