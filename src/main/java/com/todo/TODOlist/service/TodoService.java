package com.todo.TODOlist.service;


import com.todo.TODOlist.entity.Todo;
import com.todo.TODOlist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // POST
    public Todo saveTodo(Todo Todo) {
        System.out.println(Todo.toString());
        return todoRepository.save(Todo);
    }
    public List<Todo> saveTodos(List<Todo> Todos) {
        return todoRepository.saveAll(Todos);
    }

    // GET
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }
    public Todo getTodoById(int id) {
        return todoRepository.findById(id).orElse(null);
    }
    public Todo getTodoByName(String name) {
        return todoRepository.findByName(name);
    }

    // PUT
    public Todo updateTodo(Todo todo) {
        Todo t = todoRepository.findById(todo.getId()).orElse(null);
        t.setName(todo.getName());
        t.setDescription(todo.getDescription());
        t.setStatus(todo.getStatus());
        return todoRepository.save(t);
    }

    // DELETE
    public String deleteTodo(int id) {
        todoRepository.deleteById(id);
        return "Id: " + id + " deleted";
    }
}
