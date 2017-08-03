package com.forestnewark.repository;

import com.forestnewark.bean.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessageLogRepository extends JpaRepository<Log, Integer> {

    List<Log> findAllByOrderById();

    List<Log> findAllByOrderByStudentName();

    List<Log> findAllByOrderByParentName();

    List<Log> findAllByOrderByTemplateSent();

    List<Log> findAllByOrderBySentBy();

    List<Log> findAllByOrderByCreated();



    // Allowing the user the ability to search by ID, StudentName, ParentName, TemplateSent, Notes, Created(Datetimestamp)
    List<Log> findByStudentNameIgnoreCaseContainingOrParentNameIgnoreCaseContainingOrTemplateSentIgnoreCaseContainingOrSentByIgnoreCaseContaining(String studentName, String parentName, String templateSent, String notes);


}
