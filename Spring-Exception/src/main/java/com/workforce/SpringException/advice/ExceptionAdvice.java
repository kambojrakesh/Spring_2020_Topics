package com.workforce.SpringException.advice;

import com.workforce.SpringException.controller.ExceptionController;
import com.workforce.SpringException.exception.RtnMessageForException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(assignableTypes = ExceptionController.class)
public class ExceptionAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<RtnMessageForException> art(HttpServletRequest request, ArithmeticException e ){
        RtnMessageForException c=new RtnMessageForException("error-101","Exception","Divide by zero in custom advice, "+e.getMessage());
        return new ResponseEntity<>(c, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
