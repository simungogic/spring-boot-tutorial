package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //expose "/" that return "Hello World"
    @Value("${credentials.username}")
    private String username;
    @Value("${credentials.password}")
    private String password;
    @GetMapping("/")
    public String sayHello() {
        return "username: %10s, password: %10s".formatted(username, password);
    }
}
