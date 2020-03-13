package com.workforce.security.rest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/service")
public class LoginController {

               @RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
               // To enable method level authorization using @PreAuthorize 
               //@PreAuthorize("hasRole('USER')") 
               public ResponseEntity<String> welcomePage() {
                              System.out.println("home called");
                              return new ResponseEntity<>(
                                                   "Welcome to Homepage ", 
                                                   HttpStatus.OK);
               }

               
               @RequestMapping(value = {"/userPage"}, method = RequestMethod.GET)
               public ResponseEntity<String>  userPage() {
                              return new ResponseEntity<>(
                                                   "Welcome to User page ", 
                                                   HttpStatus.OK);
               }
               
               @RequestMapping(value = {"/adminPage"}, method = RequestMethod.GET)
               @PreAuthorize("hasRole('USER')")
               public ResponseEntity<String>  adminPage() {
                              return new ResponseEntity<>(
                                                   "Welcome to Admin Page ", 
                                                   HttpStatus.OK);
               }
               


}
