package services;

import org.springframework.stereotype.Service;

@Service(value = "english")
public class Service1Impl2 implements Service1 {
    private String message=" What a lovely day.";

    public void setMessage(String msg){
        message=msg;
    }

    public String hello(String nom) {
        return "Hie "+nom+". "+message;
    }
}
