package com.example.Foodorderapp.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler(){

    }

    @ExceptionHandler({BillException.class})
    public ResponseEntity<ErrorDetails> billExceptionHandler(BillException billException, WebRequest webRequest){
        ErrorDetails err = new ErrorDetails();
        err.setLocalDateTime(LocalDateTime.now());
        err.setMessage(billException.getMessage());
        err.setDetails(webRequest.getDescription(false));
        return new ResponseEntity(err, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({CartException.class})
    public ResponseEntity<ErrorDetails> cartExceptionHandler(CartException ce, WebRequest wr) {
        ErrorDetails err = new ErrorDetails();
        err.setLocalDateTime(LocalDateTime.now());
        err.setMessage(ce.getMessage());
        err.setDetails(wr.getDescription(false));
        return new ResponseEntity(err, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({CategoryException.class})
    public ResponseEntity<ErrorDetails> categoryExceptionHandler(CategoryException categoryException,WebRequest webRequest){
        ErrorDetails err = new ErrorDetails();
        err.setLocalDateTime(LocalDateTime.now());
        err.setMessage(categoryException.getMessage());
        err.setDetails(webRequest.getDescription(false));
        return new ResponseEntity(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CustomerException.class})
    public ResponseEntity<ErrorDetails> customerExceptionHandler(CustomerException customerException,WebRequest webRequest){
        ErrorDetails err = new ErrorDetails();
        err.setLocalDateTime(LocalDateTime.now());
        err.setDetails(webRequest.getDescription(false));
        err.setMessage(customerException.getMessage());
        return new ResponseEntity(err,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ItemException.class})
    public ResponseEntity<ErrorDetails> itemExceptionHandler(ItemException itemException,WebRequest webRequest){
        ErrorDetails err = new ErrorDetails();
        err.setLocalDateTime(LocalDateTime.now());
        err.setMessage(itemException.getMessage());
        err.setDetails(webRequest.getDescription(false));
        return new ResponseEntity(err,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RestaurantException.class})
    public ResponseEntity<ErrorDetails> restaurantExceptionHandler(RestaurantException restaurantException,WebRequest webRequest){
        ErrorDetails err = new ErrorDetails();
        err.setLocalDateTime(LocalDateTime.now());
        err.setMessage(restaurantException.getMessage());
        err.setDetails(webRequest.getDescription(false));
        return new ResponseEntity(err,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDetails> ExceptionHandler(Exception exception,WebRequest webRequest){
        ErrorDetails err = new ErrorDetails();
        err.setLocalDateTime(LocalDateTime.now());
        err.setMessage(exception.getMessage());
        err.setDetails(webRequest.getDescription(false));
        return new ResponseEntity(err,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
