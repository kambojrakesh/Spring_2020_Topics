package com.example.SpringProjection.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringProjection.Dto.ClassDto;
import com.example.SpringProjection.Dto.PersonDto;
import com.example.SpringProjection.Dto.PersonView;
import com.example.SpringProjection.Service.ProjectionService;

@RestController
@RequestMapping("/projection")
public class ProjectionController {
	
	@Autowired
	ProjectionService proService;
	
	@RequestMapping(method= RequestMethod.GET, value = "/hello" )
	public String sayHello() {
		System.out.println("Hello");
		return "Hello";
	}
	
	@RequestMapping(method= RequestMethod.GET, value = "/getAllPersons" )
	public ResponseEntity<List<PersonDto>> getAllPersons(){
		
		return ResponseEntity.ok(proService.getAllPersons());
	}
	
	@RequestMapping(method= RequestMethod.GET, value = "/getAllPersons1" )
	public ResponseEntity<List<PersonDto>> getAllPersons1(){
		
		return ResponseEntity.ok(proService.getAllPersons1());
	}
	
	@RequestMapping(method= RequestMethod.GET, value = "/getAllPersons/{state}" )
	public List<String> closedProjection(@PathVariable("state") String state) {
		
		return proService.closedProjection(state);
	}
	
	@RequestMapping(method= RequestMethod.GET, value = "/lastName/{lastName}" )
	public PersonDto findByLastName(@PathVariable("lastName") String lastName) {
		
		return proService.findByLastName(lastName);
	}
	
	@RequestMapping(method= RequestMethod.GET, value = "/fullName/{lastName}" )
	public PersonView findFullName(@PathVariable("lastName") String lastName) {
		
		return proService.findFullName(lastName);
	}
	
	@RequestMapping(method= RequestMethod.GET, value = "/class/{lastName}" )
	public ClassDto classProjection(@PathVariable("lastName") String lastName) {
		
		return proService.findByLastNameClass(lastName);
	}
}
