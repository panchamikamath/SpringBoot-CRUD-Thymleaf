package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	//add exception handling code here
	
		@ExceptionHandler
		public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException ex){
			//create CustomerErrorResponse
			CustomerErrorResponse error = new CustomerErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(ex.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
		
		//add another exception handler... to catch any exception
		@ExceptionHandler
		public ResponseEntity<CustomerErrorResponse> handleException(Exception ex){
			//create CustomerErrorResponse
			CustomerErrorResponse error = new CustomerErrorResponse();
			
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(ex.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		}
}
