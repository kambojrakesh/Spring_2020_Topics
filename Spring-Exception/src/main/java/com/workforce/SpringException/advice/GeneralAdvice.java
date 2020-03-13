package com.workforce.SpringException.advice;


import com.workforce.SpringException.exception.AppException;
import com.workforce.SpringException.exception.RtnMessageForException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GeneralAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        RtnMessageForException c=new RtnMessageForException("error-303","Bad Request","Unsupported Request");
        return new ResponseEntity<>(c, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<RtnMessageForException> art(HttpServletRequest request,ArithmeticException e ){
        RtnMessageForException c=new RtnMessageForException("error-301","Exception","Divide by zero using general Advice");
        return new ResponseEntity<>(c, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        RtnMessageForException c=new RtnMessageForException("error-302","Bad Request","Please provide complete details");
        return new ResponseEntity<>(c, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<RtnMessageForException> custom(HttpServletRequest request,AppException e){
        RtnMessageForException c=new RtnMessageForException(e.getErrorCode(),"Exception",e.getErrorDesc());
        return new ResponseEntity<>(c, HttpStatus.BAD_REQUEST);
    }


}
