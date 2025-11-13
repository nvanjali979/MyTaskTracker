package com.codeninjava.tasktracker.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codeninjava.tasktracker.model.Task;
import com.codeninjava.tasktracker.repo.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepo;
	

	public TaskService(TaskRepository taskRepo) {
		this.taskRepo = taskRepo;
	}

	public Task createTask(Task task) {
		return taskRepo.save(task);
	}

	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}

	public void deleteTaskById(Long id) {
		taskRepo.deleteById(id);
	}

	public ResponseEntity<Task> complete(Long id) {
		return taskRepo.findById(id).map(task -> {
			task.setCompleted(true);
			return ResponseEntity.ok(taskRepo.save(task));
		}).orElse(ResponseEntity.notFound().build());
	}

}
