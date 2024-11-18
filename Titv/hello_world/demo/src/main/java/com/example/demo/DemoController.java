package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/")
   public String index(){
        return  "Hello World";
    }

    @GetMapping("/h2")
    public String index2(){
        return  "Xin chao";
    }
}
