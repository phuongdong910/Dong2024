package com.codegym.thuchanhcontrustrorinjection.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"com.codegym.thuchanhcontrustrorinjection.application",
        "com.codegym.thuchanhcontrustrorinjection.service",
        "com.codegym.thuchanhcontrustrorinjection.rest"}
)
public class ThuchanhContrustrorInjectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThuchanhContrustrorInjectionApplication.class, args);
    }

}
