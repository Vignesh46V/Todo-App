package vicky.project.HelloWorld.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vicky.project.HelloWorld.models.Todo;



public interface TodoRepository extends JpaRepository<Todo, Long> {

}
