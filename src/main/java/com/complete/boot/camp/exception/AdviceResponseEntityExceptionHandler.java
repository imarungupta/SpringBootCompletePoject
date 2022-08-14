package com.complete.boot.camp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.*;

@RestControllerAdvice
public class AdviceResponseEntityExceptionHandler{


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DepartmentNotFoundException.class)
    ResponseEntity<ErrorMessage> departmentNotFoundException
            (DepartmentNotFoundException deptNotFoundEx, WebRequest webRequest){
        ErrorMessage errorMessage= new ErrorMessage(HttpStatus.NOT_FOUND,deptNotFoundEx.getMessage(),new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Set<String> handleInvalidArgumentException(ConstraintViolationException ex){
        Set<String> errorMessage= new HashSet<>();
        errorMessage.add(ex.getMessage());
        return errorMessage;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex){

        Map<String, String> errorMap = new HashMap<>();
        // First get all the bind error message list from MethodArgumentNotValidException
        // Iterate this list and based on its field get the default message
        ex.getBindingResult().getFieldErrors().forEach(error -> { // Iterating the list
            errorMap.put(error.getField(),error.getDefaultMessage()); // putting the error message in map
        });
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TransactionSystemException.class)
    public Map<String, String> handleInvalidArgument(TransactionSystemException ex){

        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage",ex.getMessage());
        return errorMap;
    }
}
