package com.todo.TODOlist.controller;

import com.todo.TODOlist.entity.Todo;
import com.todo.TODOlist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = { "http://localhost:9000"})
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    // POST
    @PostMapping("/addTodo")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.saveTodo(todo);
    }

    @PostMapping("/addTodos")
    public List<Todo> addTodos(@RequestBody List<Todo> todos) {
        return todoService.saveTodos(todos);
    }

    // GET
    @GetMapping("/Todos")
    public List<Todo> getAllTodos() {
        return todoService.getTodos();
    }
    @GetMapping("/TodoById/{id}")
    public Todo findTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }
    @GetMapping("/TodoByName/{name}")
    public Todo findTodoByName(@PathVariable String name) {
        return todoService.getTodoByName(name);
    }

    // PUT
    @PutMapping("/update")
    public Todo updateTodo(@RequestBody Todo todo)
    {
        return todoService.updateTodo(todo);
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        return todoService.deleteTodo(id);
    }
}
