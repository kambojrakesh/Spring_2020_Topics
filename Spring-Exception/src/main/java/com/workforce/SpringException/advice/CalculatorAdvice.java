package com.workforce.SpringException.advice;

import com.workforce.SpringException.controller.CalculatorController;
import com.workforce.SpringException.exception.RtnMessageForException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice(assignableTypes = CalculatorController.class)
public class CalculatorAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<RtnMessageForException> art(HttpServletRequest request, ArithmeticException e ){
        RtnMessageForException c=new RtnMessageForException("error-201","Exception","Divide by zero in calculator");
        return new ResponseEntity<>(c, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
