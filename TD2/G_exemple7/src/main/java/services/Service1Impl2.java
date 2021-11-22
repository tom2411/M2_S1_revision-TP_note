package services;

public class Service1Impl2 implements Service1 {
    private String message=" What a lovely day.";

    public void setMessage(String msg){
        message=msg;
    }

    public String hello(String nom) {
        return "Hie "+nom+". "+message;
    }
}
