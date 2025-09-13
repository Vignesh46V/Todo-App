package vicky.project.HelloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/ak")
    String sayHi(){
        return"Hi Ak!";
    }
}
