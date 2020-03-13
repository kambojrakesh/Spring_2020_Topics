package com.workforce.DatabaseVersioning.dao;

import com.workforce.DatabaseVersioning.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDao extends PagingAndSortingRepository<Student,Long>, QueryByExampleExecutor<Student> {

    //More information At- https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

    Page<Student> findByPh(@Param("ph") String ph, Pageable pageable);
    List<Student> findByStudentName(@Param("studentName") String studentName);

    @Query("select s from Student s where s.emailId=:email")
    Optional<Student> findEmail(@Param("email") String email);

    @Query("select s from Student s where s.ph=:ph and s.studentName=:studentName")
    List<Student> findPhAndName(@Param("ph") String email,@Param("studentName") String studentName);

    @Query(value = "select * from student where student_name=:name",nativeQuery = true)
    List<Student> getStudent(@Param("name") String name);


}
