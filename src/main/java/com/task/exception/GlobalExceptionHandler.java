package com.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DuplicateTaskDescriptionException.class)
	public ResponseEntity<String> handleDuplicateDescription(DuplicateTaskDescriptionException  ex){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
		
	}
	
	@ExceptionHandler(TaskNotAvailableException.class)
	public ResponseEntity<String> handleAvailable(TaskNotAvailableException ex){
		//String error = ex.getMessage()+id;
		return ResponseEntity.status(HttpStatus.OK).body(ex.getMessage());
		
	}
}
