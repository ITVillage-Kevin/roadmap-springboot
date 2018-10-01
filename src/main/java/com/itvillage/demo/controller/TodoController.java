package com.itvillage.demo.controller;

import com.itvillage.demo.domain.Todo;
import com.itvillage.demo.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value = "/todo/register", method = RequestMethod.POST)
    @ResponseBody
    public Todo register(Todo todo){
        todoRepository.save(todo);
        return todo;
    }

    @RequestMapping(value = "/todo/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> getTodoList(){
        return todoRepository.findAll();
    }
}
