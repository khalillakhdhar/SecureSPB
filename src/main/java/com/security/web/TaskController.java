package com.security.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.dao.TaskRepository;
import com.security.model.Task;

import jakarta.validation.Valid;

@RestController
public class TaskController {
@Autowired
TaskRepository taskRepository;
@GetMapping("tasks")
public List<Task> getAllTasks()
{
return taskRepository.findAll();	

}
@PostMapping("tasks")
public Task addOneTask(@Valid @RequestBody Task task)
{
	return taskRepository.save(task);
	
}
}
