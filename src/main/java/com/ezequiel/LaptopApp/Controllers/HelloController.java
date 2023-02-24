package com.ezequiel.LaptopApp.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${app.varexample}")
    String message;
    @GetMapping("/api/hello")
    public String hello() {
        System.out.println(message);
        return message;
    }
}
