package com.security;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.security.dao.TaskRepository;
import com.security.model.Task;


@SpringBootApplication
public class SecureSpbApplication implements CommandLineRunner {
@Autowired
TaskRepository taskRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SecureSpbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Stream.of("T1","T2","T3").forEach(t->{
			taskRepository.save(new Task(0, t));
			});
		taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
			});
			}
	}


