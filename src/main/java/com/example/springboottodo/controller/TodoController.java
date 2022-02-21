package com.example.springboottodo.controller;

import com.example.springboottodo.entity.Todo;
import com.example.springboottodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    TodoRepository todoRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<Todo> getAllTodo() {
        return todoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    Todo postTodo(@RequestBody @Validated Todo todo) {
        return todoRepository.save(todo);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    Todo getTodo(@PathVariable("id") Long id) {
        return todoRepository.findById(id).get();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    @ResponseBody
    Todo doneTodo(@PathVariable("id") Long id) {
        Todo todo = todoRepository.findById(id).get();
        todo.setDone(true);
        return todoRepository.save(todo);
    }
}
