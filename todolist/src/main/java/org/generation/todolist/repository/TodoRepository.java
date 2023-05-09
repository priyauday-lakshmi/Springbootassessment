package org.generation.todolist.repository;

import org.generation.todolist.entity.Todo;
import org.springframework.data.repository.CrudRepository;


public interface TodoRepository extends CrudRepository<Todo, Integer>{



}
