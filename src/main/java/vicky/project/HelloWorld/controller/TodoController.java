package vicky.project.HelloWorld.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vicky.project.HelloWorld.service.TodoService;
import vicky.project.HelloWorld.models.Todo;

import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
@Slf4j
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/home")
    String getTodo(){
        return "Hello World!";
    }

    @GetMapping("/list")
    String newTodo(){
        return "New ToDo";
    }

    //pathVariable
    @GetMapping("/{id}")
    ResponseEntity<Todo> getToDoById(@PathVariable long id){
        try {
            return new ResponseEntity<>(todoService.getTodoByID(id),HttpStatus.OK) ;
        }catch (RuntimeException e){
            log.info("Error");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<List<Todo>>(todoService.getAllTodos(),HttpStatus.OK);
    }

    //RequestParam
    @GetMapping("/idm")
    String getTodoByIdParam(@RequestParam("todoId") long id){
        return "todo with id "+id;
    }

    @PostMapping("/create")
    ResponseEntity<Todo>CreateUser(@Valid @RequestBody Todo todo){
        return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<Todo> updateTodoById(@Valid @RequestBody Todo todo){
        return new ResponseEntity<>(todoService.updateTodo(todo),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteTodoById(@PathVariable long id){
        todoService.deleteTodoById(id);
    }

    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getTodosPaged(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<>(todoService.getAllTodosPages(page, size),HttpStatus.OK);
    }

}
