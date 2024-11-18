package com.codegym.demo19;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Caculator myCaculator;

    @Autowired
    public Controller(@Qualifier("getCaculator") Caculator myCaculator) {
        this.myCaculator = myCaculator;
    }

    @GetMapping("/canBacHai")
    public String tinhCanBacHai(@RequestParam("value") double x) {
 return "SQRT (" + x + ") =" + myCaculator.canBachai(x);
    }

    @GetMapping("/binhPhuong")
    public String tinhBinhPhuong(@RequestParam("value") double x) {
        return "(" + x +"^2) =" + myCaculator.binhPhuong(x);
    }
}
