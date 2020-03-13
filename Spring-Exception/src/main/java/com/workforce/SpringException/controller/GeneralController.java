package com.workforce.SpringException.controller;

import com.workforce.SpringException.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/general")
public class GeneralController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<Integer> divide(@RequestParam int a, @RequestParam int b){
        return ResponseEntity.ok(a/b);
    }

    @GetMapping(path = "/custom",produces = "application/json")
    public ResponseEntity<Integer> divideCustom(@RequestParam int a, @RequestParam int b){
        int c;
        try {
            c=(a / b);
        } catch (Exception e){
            throw new AppException("Error-1","Divide by Zero is not allowed");
        }
        return ResponseEntity.ok(c);
    }

    @GetMapping(path = "/null")
    public ResponseEntity<Integer> nullException(){
        AppException appException=null;
        appException.getErrorCode();
        return ResponseEntity.ok(1);
    }
}
