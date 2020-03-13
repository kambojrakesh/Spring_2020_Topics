package com.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "User page";
	}
	
	
	@RequestMapping("/admin")
	public String admin() {
		return "Admin Page";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "Home";
	}

}
