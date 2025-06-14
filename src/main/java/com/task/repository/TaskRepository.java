package com.task.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.Task;
import com.task.enums.TaskStatus;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
	Optional<Task> findByDescription(String description);
	//List<Task> findByStatus(TaskStatus status);
	List<Task> findByStatus(TaskStatus status);
}
