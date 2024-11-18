package com.codegym.thuchanhcontrustrorinjection.rest;


import com.codegym.thuchanhcontrustrorinjection.service.EmailService;
import com.codegym.thuchanhcontrustrorinjection.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private MessageService service;
    private MessageService service2;

//    @Autowired
//   public NotificationController(@Qualifier("zaloService") MessageService service){
//        this.service = service;
//    }

    public NotificationController(
            @Qualifier("emailService") MessageService service,
            @Qualifier("emailService") MessageService service2) {
        this.service = service;
        this.service2 = service2;
    }


    /* Setter injection

     */
//    @Autowired
//    public void ganEmail(EmailService email){
//        this.email = email;
//    }

    @GetMapping("/send-email")
    public  String sendEmail(){
        return  this.service.sendMessage();
    }

    @GetMapping ("/check")
    public String check () {
        return "Kiem  tra: " + (service == service2) ;
    }

    @GetMapping("/check2")
    public  String check2 () {
        if ( service == service2)
            return "SINGLETON";
        else
            return "PROTOTYPE";
    }
}
