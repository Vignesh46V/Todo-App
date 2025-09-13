package vicky.project.HelloWorld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vicky.project.HelloWorld.models.Todo;
import vicky.project.HelloWorld.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public  Todo getTodoByID(Long id){
        return todoRepository.findById(id).orElseThrow(()->new RuntimeException("Todo not found."));
    }

    public Page<Todo> getAllTodosPages(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return todoRepository.findAll(pageable);
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo updateTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public void deleteTodoById(Long id){
        todoRepository.deleteById(id);
    }

    public void deleteTodo(Todo todo){
        todoRepository.delete(todo);
    }


}
