package services;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;


public class Service3 {
    Random rand=new Random();
    private Service6 conseil;
    private Service4 service;

    public void setConseil(Service6 conseil) {
        this.conseil=conseil;
    }

    public void setService(Service4 service) {
        this.service = service;
    }

    public String codeUnique() {
        StringBuilder sb=new StringBuilder(service.phrase());
        sb.append(rand.nextInt());
        sb.append(".");
        sb.append(conseil.getConseil());
        return  sb.toString();
    }
}
