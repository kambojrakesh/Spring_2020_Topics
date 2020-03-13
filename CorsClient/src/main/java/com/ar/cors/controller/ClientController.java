package com.ar.cors.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {
	 
	@GetMapping("/client")
	    public String home() {
	        return "client";
	    }
}
