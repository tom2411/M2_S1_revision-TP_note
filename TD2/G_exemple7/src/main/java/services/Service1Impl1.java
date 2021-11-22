package services;

public class Service1Impl1 implements Service1 {
    private String message=" Quelle belle journée.";

    public void setMessage(String msg){
        message=msg;
    }

    public String hello(String nom) {
        return "Bonjour "+nom+". "+message;
    }
}
