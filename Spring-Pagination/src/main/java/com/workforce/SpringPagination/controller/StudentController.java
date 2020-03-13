
package com.workforce.SpringPagination.controller;

import com.workforce.SpringPagination.model.Student;
import com.workforce.SpringPagination.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/page")
    public ResponseEntity<Page<Student>> getStudentpage(@PageableDefault(size = 5,page = 0)  Pageable pageable){
        return ResponseEntity.ok(studentService.getAllStudentPage(pageable));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Long> saveStudent(Student student){
        return ResponseEntity.ok(studentService.save(student));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Long> updateStudent(Student student){
        return ResponseEntity.ok(studentService.update(student));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(Long id){
        return ResponseEntity.ok(studentService.delete(id));
    }
}

