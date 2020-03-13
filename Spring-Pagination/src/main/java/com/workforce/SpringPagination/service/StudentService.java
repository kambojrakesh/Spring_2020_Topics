package com.workforce.SpringPagination.service;

import com.workforce.SpringPagination.dao.StudentDao;
import com.workforce.SpringPagination.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentService {

    StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAll(){
        return StreamSupport.stream(studentDao.findAll().spliterator(),false).collect(Collectors.toList());
    }

    public Page<Student> getAllStudentPage(Pageable pageable){
        return studentDao.findAll(pageable);
    }

    public Page<Student> getAllStudentSort(){
        return studentDao.findAll(PageRequest.of(0,2, Sort.Direction.ASC));
    }

    public Long save(Student student) {
        return studentDao.save(student).getStudentId();
    }

    public Long update(Student student) {
        if(studentDao.findById(student.getStudentId()).isPresent()){
            return studentDao.save(student).getStudentId();
        } else {
            return 0L;
        }
    }

    public Student delete(Long id){
        Student s;
        if(studentDao.findById(id).isPresent()){
            s=studentDao.findById(id).get();
            studentDao.deleteById(id);
            return s;
        } else {
            return null;
        }
    }
}
