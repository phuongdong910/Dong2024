package com.codegym.thuchanhcontrustrorinjection.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageService{

    public SmsService (){
        System.out.println("Constructor cua lơp : " + getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "SMS sending  123 ....";
    }
}
