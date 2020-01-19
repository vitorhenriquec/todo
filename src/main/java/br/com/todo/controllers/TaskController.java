package br.com.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todo.domain.Task;
import br.com.todo.service.TaskService;

@RestController
@CrossOrigin
@RequestMapping({"api/v1/task"})
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@GetMapping
	public List<Task> findAll() throws NullPointerException{
		return service.listAll();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Task task){
		Task taskSaved = service.save(task);
		if(taskSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(task,HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("/{id}")
	public ResponseEntity updateActive(@PathVariable("id") long id){
		return service.searchItem(id).map( (taskUpdated) -> {
			taskUpdated.setActive(!taskUpdated.isActive());
			service.update(taskUpdated);
			return ResponseEntity.ok().body(taskUpdated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") long id){
		service.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
