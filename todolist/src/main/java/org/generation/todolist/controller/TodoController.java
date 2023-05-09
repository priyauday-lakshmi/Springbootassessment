package org.generation.todolist.controller;


import org.generation.todolist.controller.dto.TodoDTO;
import org.generation.todolist.entity.Todo;
import org.generation.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;
    public TodoController(@Autowired TodoService todoservice){
        this.todoService = todoservice;
    }
    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Todo>  getTodo(){
        return todoService.all();
    }
    @CrossOrigin
    @PostMapping("/add")
    public  void save( @RequestParam(name="title", required = true) String title,
                       @RequestParam(name ="description", required = true)String description
                       ) throws IOException

    {
        TodoDTO todoDto = new TodoDTO(title, description);

        todoService.save(new Todo(todoDto) );

    }

}
