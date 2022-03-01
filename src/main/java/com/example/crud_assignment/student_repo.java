/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.crud_assignment;

/**
 *
 * @author Payal
 */
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
public interface student_repo extends CrudRepository<student,Integer>{
    @Transactional
    @Modifying()
    @Query("update students s set s.name=:name where s.id=:id")
     void setStudentName(@Param("id") int id, @Param("name") String name);
}
