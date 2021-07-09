package com.solution.webservice.controller;

import java.util.EmptyStackException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
    extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value
      = {  EmptyStackException.class })
  protected ResponseEntity<Object> handleConflict(
      RuntimeException ex, WebRequest request) {
    String bodyOfResponse = "The stack is empty";
    return handleExceptionInternal(ex, bodyOfResponse,
        new HttpHeaders(), HttpStatus.NO_CONTENT, request);
  }



    @ExceptionHandler(value
        = { IllegalArgumentException.class, StackOverflowError.class })
    protected ResponseEntity<Object> handleError(
        RuntimeException ex, WebRequest request) {
      String bodyOfResponse = ex.getLocalizedMessage();
      return handleExceptionInternal(ex, bodyOfResponse,
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}