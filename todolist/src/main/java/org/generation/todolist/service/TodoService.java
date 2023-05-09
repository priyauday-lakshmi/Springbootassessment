package org.generation.todolist.service;

import org.generation.todolist.entity.Todo;

import java.util.ArrayList;

public interface TodoService {

    Todo save(Todo todo);
    ArrayList<Todo> all();
}
