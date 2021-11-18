package id.liostech.springpus.controllers;

import id.liostech.springpus.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<?> validationHandler(ConstraintViolationException constraintViolationException){
        ApiResponse response = new ApiResponse();
        response.setStatus(false);
        constraintViolationException.getConstraintViolations().forEach(constrain -> response.getMessages().add(constrain.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
