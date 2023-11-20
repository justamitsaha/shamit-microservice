package com.saha.amit.getPostApp.controler;

import com.saha.amit.getPostApp.dto.ErrorResponse;
import com.saha.amit.getPostApp.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandellerControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handelException(CustomException customException){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(customException.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorResponse);

    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handelException2(RuntimeException exception){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorResponse);

    }
}
