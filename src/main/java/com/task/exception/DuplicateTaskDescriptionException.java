package com.task.exception;

public class DuplicateTaskDescriptionException extends RuntimeException{
	
	public DuplicateTaskDescriptionException(String message) {
		super(message);
	}
}
