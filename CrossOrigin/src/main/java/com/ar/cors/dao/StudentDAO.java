package com.ar.cors.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ar.cors.bean.Product;
import com.ar.cors.bean.Student;

@Component
public class StudentDAO {

	private static Map<Integer, Student> studentRepo = new HashMap<>();
	
	private static Map<Integer, Product> productRepo = new HashMap<>();
	   static {
		  Student student_one = new Student();
		  student_one.setId(1);
		  student_one.setName("jhon");
	      studentRepo.put(student_one.getId(), student_one);
	      
	      Student student_two = new Student();
	      student_two.setId(2);
	      student_two.setName("smith");
	      studentRepo.put(student_two.getId(), student_two);
	      
	      Student student_three = new Student();
	      student_three.setId(2);
	      student_three.setName("jack");
	      studentRepo.put(student_three.getId(), student_three);
	      
	      Product product_one = new Product();
		  product_one.setId(1);
		  product_one.setName("jhon");
	      productRepo.put(product_one.getId(), product_one);
	      
	      Product product_two = new Product();
	      product_two.setId(2);
	      product_two.setName("smith");
	      productRepo.put(product_two.getId(), product_two);
	      
	      Product product_three = new Product();
	      product_three.setId(2);
	      product_three.setName("jack");
	      productRepo.put(product_three.getId(), product_three);
	   }
	   
	   public Map<Integer, Student> getAllStudents(){
		   return studentRepo;
	   }
	   
	   public Map<Integer, Product> getAllProducts(){
		   return productRepo;
	   }
	   
	   public void createStudent(Student student) {
//		   studentRepo.put(student.getId(), student.getName());
	   }
}
