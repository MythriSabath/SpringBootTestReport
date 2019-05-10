package com.training.boothibernate.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(CustomException ex){
		ErrorResponse errResponse=new ErrorResponse(
													HttpStatus.BAD_REQUEST.value(),
													ex.getMessage(), 
													System.currentTimeMillis());
		return new ResponseEntity<ErrorResponse>(errResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(BookNotFoundException ex){
		ErrorResponse errResponse=new ErrorResponse(
													HttpStatus.NOT_FOUND.value(),
													ex.getMessage(), 
													System.currentTimeMillis());
		return new ResponseEntity<ErrorResponse>(errResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(SubjectNotFoundException ex){
		ErrorResponse errResponse=new ErrorResponse(
													HttpStatus.NOT_FOUND.value(),
													ex.getMessage(), 
													System.currentTimeMillis());
		return new ResponseEntity<ErrorResponse>(errResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception ex){
		ErrorResponse errResponse=new ErrorResponse(
													HttpStatus.BAD_REQUEST.value(),
													ex.getMessage(), 
													System.currentTimeMillis());
		return new ResponseEntity<ErrorResponse>(errResponse,HttpStatus.BAD_REQUEST);
	}
}
