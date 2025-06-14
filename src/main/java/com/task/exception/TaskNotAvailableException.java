package com.task.exception;

import com.task.enums.TaskStatus;

public class TaskNotAvailableException extends RuntimeException {

	public TaskNotAvailableException(String message, Integer id) {
		// TODO Auto-generated constructor stub
		super(message+""+id);
	}

	public TaskNotAvailableException(String message, TaskStatus status) {
		// TODO Auto-generated constructor stub
		super(message+""+status);
	}
}
