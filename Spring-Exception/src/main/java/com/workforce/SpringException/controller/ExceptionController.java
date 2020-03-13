package com.workforce.SpringException.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<Integer> divide(@RequestParam int a, @RequestParam int b){
        return ResponseEntity.ok(a/b);
    }
}
