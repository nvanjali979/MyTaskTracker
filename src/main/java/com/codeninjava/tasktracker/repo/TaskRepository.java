package com.codeninjava.tasktracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeninjava.tasktracker.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{

}
