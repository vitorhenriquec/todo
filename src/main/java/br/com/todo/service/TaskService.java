package br.com.todo.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.todo.domain.Task;
import br.com.todo.repository.TaskRepository;
import br.com.todo.utils.Service;

public class TaskService implements Service<Task>{

	@Autowired
	private TaskRepository repository;
	
	@Override
	public Task save(Task element){
		return repository.save(element);
	}

	@Override
	public Task update(Task element){
		return repository.save(element);
	}
	
	@Override
	public Iterable<Task> listAll()	{
		return repository.findAll();
	}

	@Override
	public void remove(Long id){
		repository.deleteById(id);
	}
		
}
