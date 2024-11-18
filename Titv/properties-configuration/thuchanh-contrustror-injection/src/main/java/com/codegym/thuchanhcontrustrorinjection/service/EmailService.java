package com.codegym.thuchanhcontrustrorinjection.service;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {

    public EmailService (){
        System.out.println("Constructor cua lơp : " + getClass().getSimpleName());
    }

    @Override
    public String sendMessage() {
        return "Email sending by filed no constructor, no setter 123 ....";
    }
}
