package br.com.josenildo.todoapp.repository;

import br.com.josenildo.todoapp.model.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoList, Long> {

}
