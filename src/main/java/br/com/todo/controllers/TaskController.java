package br.com.todo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.todo.domain.Task;
import br.com.todo.service.TaskService;

@Controller
@RequestMapping("/task/")
public class TaskController {
	
	private TaskService service;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Task task){
		Task taskSaved = service.save(task);
		if(taskSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(task,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Task task){
		Task taskSaved = service.save(task);
		if(taskSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(task,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> remove(@RequestParam(name = "id") Long id){
		service.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
