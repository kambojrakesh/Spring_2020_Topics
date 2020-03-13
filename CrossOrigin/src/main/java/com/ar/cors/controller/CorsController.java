package com.ar.cors.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ar.cors.bean.Product;
import com.ar.cors.bean.Student;
import com.ar.cors.dao.StudentDAO;

@RestController
@RequestMapping("/cors")
@CrossOrigin(origins = "http://localhost:9090", methods = RequestMethod.GET, allowedHeaders = "Authorization", exposedHeaders = "Keep-Alive", maxAge = 3600)
public class CorsController {
	
	@Autowired
	StudentDAO studentDAO;
	
	@GetMapping("/students")
	public ResponseEntity<Object> getStudents(){
		Map<Integer, Student> students = studentDAO.getAllStudents();
		return new ResponseEntity<>(students.values(), HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public ResponseEntity<Object> getProducts(){
		Map<Integer, Product> products = studentDAO.getAllProducts();
		return new ResponseEntity<>(products.values(), HttpStatus.OK);
	}
	
	@PostMapping("/students")
	public String createStudent() {
		return "post method";
	}
}
