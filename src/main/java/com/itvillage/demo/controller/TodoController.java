package com.itvillage.demo.controller;

import com.itvillage.demo.domain.Todo;
import com.itvillage.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private TodoRepository todoRepository;

    @Autowired
    TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @PostMapping(value = "/todo/register")
    public Todo register(@RequestBody Todo todo){
        todoRepository.save(todo);
        return todo;
    }

    @GetMapping(value = "/todo/list")
    public List<Todo> getTodoList(){
        return todoRepository.findAll();
    }
}
