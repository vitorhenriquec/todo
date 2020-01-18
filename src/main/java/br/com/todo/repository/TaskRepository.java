package br.com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.todo.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
