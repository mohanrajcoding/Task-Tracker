package com.task.controler;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.controler.service.TaskService;
import com.task.entity.Task;
import com.task.enums.TaskStatus;

@RestController
@RequestMapping("/tasks")
public class TaskControler {
	
	@Autowired
	private TaskService ts;
	
	@PostMapping("/add")
	public ResponseEntity<Task> addTask(@RequestBody Task task) {
		Task savedTask = ts.addTask(task);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Task> updateTask(@RequestBody Task task){
		Task update = ts.updateTask(task);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
	}
	

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        ts.deleteTask(id);
		return ResponseEntity.ok("Task Deleted");
    }
	
    @PutMapping("/inprogress/{id}")
   	public ResponseEntity<Task> markStatus(@PathVariable Integer id){
   		Task mark = ts.markStatus(id);
   		return ResponseEntity.status(HttpStatus.ACCEPTED).body(mark);
   	}
    
	@PutMapping("/done/{id}")
	public ResponseEntity<Task> statusDone(@PathVariable Integer id){
		Task mark = ts.statusDone(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(mark);
	}
	
	@GetMapping("/list")
    public ResponseEntity<List<Task>> listTasks() {
		List<Task> list = ts.listTasks();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/listbystatus/{status}")
    public ResponseEntity<List<Task>> listTasksByStatus(@PathVariable String status) {
    	try {
    		TaskStatus taskStatus= TaskStatus.valueOf(status.toUpperCase());
    		List<Task> list = ts.listTasksByStatus(taskStatus);
    		return ResponseEntity.ok(list);
    	}catch (IllegalArgumentException  e) {
			// TODO: handle exception
    		return ResponseEntity.badRequest().body(null);
		}  
    }
    
	@GetMapping("/list/{id}")
	public ResponseEntity<Task> listTaskbyId(@PathVariable Integer id) {
		Task task = ts.listTaskbyId(id);
		if(task==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(task);
	}
}
