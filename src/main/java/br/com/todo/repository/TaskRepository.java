package br.com.todo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.todo.domain.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{

}
