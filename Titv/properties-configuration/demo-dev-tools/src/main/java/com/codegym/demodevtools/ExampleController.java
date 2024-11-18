package com.codegym.demodevtools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/")
    public  String index () {
            return "I love you";
    }

    @GetMapping("/A2")
    public  String h2() {
        return  " Anh Quan, Anh Thu 11111111111ddđ dddd22222 2 " +
                "fdfdf " +
                "Tuan "  ;
    }
}

