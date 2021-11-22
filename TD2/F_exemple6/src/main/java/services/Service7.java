package services;

import java.util.Random;

public class Service7 {
    Random rand=new Random();
    private Service6 conseil;
    private Service4 service;

    public Service7(Service4 service4,Service6 service6){
        this.service=service4;
        this.conseil=service6;
    }


    public String codeUnique() {
        StringBuilder sb=new StringBuilder(service.phrase());
        sb.append(rand.nextInt());
        sb.append(".");
        sb.append(conseil.getConseil());
        return  sb.toString();
    }
}
