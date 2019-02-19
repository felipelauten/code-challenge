package com.devlauten.codingchallenge.zwitter.controller.aspect;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ZwitterExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class, NullPointerException.class})
    protected ResponseEntity<Object> handleResponse(RuntimeException ex, WebRequest request) {
        String message = "FATAL ERROR, please contact system administrator!";
        return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

//    @ExceptionHandler(value = {BusinessException.class})
//    protected ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {
//        try {
//            return handleException(ex, request);
//        } catch (Exception e) {
//            String message = "FATAL ERROR, please contact system administrator! " + e.getMessage();
//            handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.CONFLICT, request);
//        }
//        return null;
//    }
}
