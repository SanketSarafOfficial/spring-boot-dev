package com.in28minutes.rest.webservices.springbootdevelopment;

import com.in28minutes.rest.webservices.springbootdevelopment.Exception.ErrorDetails;
import com.in28minutes.rest.webservices.springbootdevelopment.Users.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //All methods for the controllerAdvice class should use the @ExceptionHandler
    //This exception is for all Exception
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex , WebRequest request){

        //This is body which we will make an object and pass the necessary details
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now()
                ,ex.getMessage()
                ,request.getDescription(false));
        // will return the ResponseEntity(body, status) -> will pass our own generic body and status
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException (Exception ex , WebRequest request){

        ErrorDetails errorDetailsForUserNotFoundException = new ErrorDetails(LocalDateTime.now()
                ,ex.getMessage()
                ,request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetailsForUserNotFoundException , HttpStatus.NOT_FOUND);
    }

    //We have taken this from ResponseEntityExceptionHandler , the structure of handleMethodArgumentNotValid
    //This is our generic exception handler to validate the name and dob in the request Body

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now()
                ,"Total error count = "+ " "+ ex.getErrorCount() + " Error message = " + ex.getFieldError().getDefaultMessage()
                ,request.getDescription(false));
        // we returned the same ResponseEntity
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
