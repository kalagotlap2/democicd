package com.example.hungerbox;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {


    @Value("${spring.info}")
    private String message;


    @GetMapping("/hi")
    public String getMessage(){
        return message;
    }
}
