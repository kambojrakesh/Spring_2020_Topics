package com.workforce.security.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workforce.security.dao.Name;
import com.workforce.security.dao.Student;
import com.workforce.security.dao.StudentDetail;

@RestController
public class SecurityController {
	
	  @GetMapping("v1/student")
	  public Student studentV1() {
	    return new Student("Bob Charlie");
	  }

	  @GetMapping("v2/student")
	  public StudentDetail studentV2() {
	    return new StudentDetail(new Name("Bob", "Charlie"));
	  }
	
}
