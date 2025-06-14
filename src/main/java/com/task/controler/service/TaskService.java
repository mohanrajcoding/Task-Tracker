package com.task.controler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entity.Task;
import com.task.enums.TaskStatus;
import com.task.exception.DuplicateTaskDescriptionException;
import com.task.exception.TaskNotAvailableException;
import com.task.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository tr;

	public Task addTask(Task task) {
		// TODO Auto-generated method stub
		Optional<Task> existingTask = tr.findByDescription(task.getDescription());
		if(existingTask.isPresent()) {
			throw new DuplicateTaskDescriptionException("The Task is already Available");
		}
		return tr.save(task);
	}

	public Task listTaskbyId(Integer id) {
		// TODO Auto-generated method stub
		return tr.findById(id).orElseThrow(()->new TaskNotAvailableException("Task is not Available for :", id));
	}

	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		Task existingTask = tr.findById(task.getId()).orElseThrow
				(()->new TaskNotAvailableException("Task is not Available for :",task.getId()));
		existingTask.setDescription(task.getDescription());
		existingTask.setStatus(task.getStatus());
		return tr.save(existingTask);
	}

	public Task statusDone(Integer id) {
		// TODO Auto-generated method stub
		Task markStatusDone = tr.findById(id).orElseThrow(()-> new TaskNotAvailableException("Task is not Available for :", id));
		markStatusDone.setStatus(TaskStatus.DONE);
		return tr.save(markStatusDone);
	}

	public List<Task> listTasks() {
		// TODO Auto-generated method stub
		return tr.findAll();
	}

	public List<Task> listTasksByStatus(TaskStatus status) {
		// TODO Auto-generated method stub
		List <Task> list = tr.findByStatus(status);
		if(list.isEmpty()) {
			throw new TaskNotAvailableException ("Task is not Available for :", status);
		}
		return tr.findByStatus(status);
	}

	public void deleteTask(Integer id) {
		// TODO Auto-generated method stub
		tr.deleteById(id);
		
	}

	public Task markStatus(Integer id) {
		// TODO Auto-generated method stub
		Task task = tr.findById(id).orElseThrow(()->new TaskNotAvailableException("Task is not Available for :", id));
		task.setStatus(TaskStatus.IN_PROGRESS);
		return tr.save(task);
	}

	
}
