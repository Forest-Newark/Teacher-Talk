package com.forestnewark.repository;

import com.forestnewark.bean.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cmitchell on 5/1/17.
 */
public interface MessageLogRepository extends JpaRepository<Log, Integer>{

}
