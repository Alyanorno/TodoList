package com.todo.TODOlist.repositories;

import com.todo.TODOlist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    Todo findByName(String name);
}
