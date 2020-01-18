package br.com.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todo.domain.Task;
import br.com.todo.repository.TaskRepository;

@Service
public class TaskService{

	@Autowired
	private TaskRepository repository;
	
	
	public Task save(Task element){
		return repository.save(element);
	}

	public Task update(Task element){
		return repository.save(element);
	}
	
	public List<Task> listAll(){
		return repository.findAll();
	}

	public void remove(long id){
		repository.deleteById(id);
	}
	
	public Optional<Task> searchItem(long id) {
		return repository.findById(id);
	}
		
}
