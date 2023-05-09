package org.generation.todolist.service;


import org.generation.todolist.entity.Todo;
import org.generation.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoServiceMySQL implements TodoService{

    private  final TodoRepository todoRepository;

    public TodoServiceMySQL(@Autowired TodoRepository todoRepository){

        this.todoRepository = todoRepository;

    }
    @Override
    public Todo save(Todo todo)
    {
        return this.todoRepository.save(todo);
    }

    @Override
    public ArrayList<Todo> all() {
        ArrayList<Todo>  result = new ArrayList<>();
        todoRepository.findAll().forEach(result::add);
        return result;
    }
}
