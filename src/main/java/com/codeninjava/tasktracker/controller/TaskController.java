package com.codeninjava.tasktracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeninjava.tasktracker.model.Task;
import com.codeninjava.tasktracker.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@PostMapping
	public Task createTasks(@RequestBody Task task) {
		return taskService.createTask(task);
	}
	
	@GetMapping
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Long id) {
		taskService.deleteTaskById(id);
		return ResponseEntity.ok("Deleted successfully");
	}
	
	@PatchMapping("/{id}/complete")
	public ResponseEntity<Task> complete(@PathVariable Long id){
		return taskService.complete(id);
	}
	
}
