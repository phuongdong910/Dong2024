package com.codegym.thuchanhcontrustrorinjection.service;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ZaloService  implements MessageService{

    @PostConstruct
    public void ịnit (){
        System.out.println("Đoạn code này được run ngay sau khi  khoi tạo" + getClass().getSimpleName());
    }

    @PreDestroy
    public void myDestroy (){
        System.out.println("Đoạn code này được run trước khi hủy bỏ" + getClass().getSimpleName());
    }
    public ZaloService (){
        System.out.println("Constructor cua lơp : " + getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return " Zalo sending .....123456";
    }
}
