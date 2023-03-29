package com.masai.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
 @ExceptionHandler(AppointmentException.class)
 public ResponseEntity<MyErrorDetails> AppointmentExceptionHandler(AppointmentException ce, WebRequest wr)
 {
	System.out.println("Inside Appointment Exception Handler");
	MyErrorDetails err = new MyErrorDetails();
	err.setTimeStamp(LocalDateTime.now());
	err.setMsg(ce.getMessage());
	err.setDetails(wr.getDescription(false));
	
	return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
 }

 @ExceptionHandler(Exception.class)
 public ResponseEntity<MyErrorDetails> anyExceptionHandler(Exception ce, WebRequest wr)
 {
	System.out.println("Inside  Exception Handler");
	MyErrorDetails err = new MyErrorDetails();
	err.setTimeStamp(LocalDateTime.now());
	err.setMsg(ce.getMessage());
	err.setDetails(wr.getDescription(false));
	
	return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
 }

 @ExceptionHandler(NoHandlerFoundException.class)
 public ResponseEntity<MyErrorDetails> myNoHandlerFoundExcHandler(NoHandlerFoundException ce, WebRequest wr)
 {
	System.out.println("Inside NoHandlerFoundException Exception Handler");
	MyErrorDetails err = new MyErrorDetails();
	err.setTimeStamp(LocalDateTime.now());
	err.setMsg(ce.getMessage());
	err.setDetails(wr.getDescription(false));
	
	return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
 }
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<MyErrorDetails> methodArgsInvalidExceptionHandler(MethodArgumentNotValidException ce, WebRequest wr)
 {
	System.out.println("Inside MethodArgumentNotValidException Exception Handler");
	MyErrorDetails err = new MyErrorDetails();
	err.setTimeStamp(LocalDateTime.now());
	err.setMsg(ce.getMessage());
	err.setDetails(wr.getDescription(false));
	
	return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
 }

 @ExceptionHandler(LoginException.class)
 public ResponseEntity<MyErrorDetails> myAdminException(LoginException ce, WebRequest req){
	
	MyErrorDetails err = new MyErrorDetails();
	err.setTimeStamp(LocalDateTime.now());
	err.setMsg(ce.getMessage());
	err.setDetails(req.getDescription(false));
	
	return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
 }
 @ExceptionHandler(VaccineRegistrationException.class)
	public ResponseEntity<MyErrorDetails> VaccineRegistrationExcHandler( VaccineRegistrationException ce , WebRequest wr ){
		
		System.out.println("Inside VaccineRegistrationExcHandler method of GlobalExceptionHandler class");
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg(ce.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
 @ExceptionHandler(PanCardException.class)
	public ResponseEntity<MyErrorDetails> pancardException(PanCardException ce, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdharCardException.class)
	public ResponseEntity<MyErrorDetails> pancardException(AdharCardException ce, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
}
