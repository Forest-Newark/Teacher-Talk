package com.forestnewark.repository;

import com.forestnewark.bean.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cmitchell on 5/1/17.
 */
public interface MessageLogRepository extends JpaRepository<Log, Integer> {

    List<Log> findAllByOrderById();

    List<Log> findAllByOrderByStudentName();

    List<Log> findAllByOrderByParentName();


//    List<Log> findAllByOrderById();
//
//   List<Log> findAllByOrderByParentName();
//
//    List<Log> findAllOrderByStudentName();
//
//    List<Log> findAllOrderByLocalDate();
//
//    List<Log> findAllOrderByTemplateSent();
//
//    List<Log> findAllOrderByNotes();
}
