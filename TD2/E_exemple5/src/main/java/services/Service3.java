package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Service3 {
    Random rand=new Random();
    private Service6 conseil;

    // injection d'un service dans un autre service...
    @Autowired
    Service4 service;

    // injection a setter
    @Autowired
    public void setConseil(Service6 conseil) {
        this.conseil=conseil;
    }

    public String codeUnique() {
        StringBuilder sb=new StringBuilder(service.phrase());
        sb.append(rand.nextInt());
        sb.append(".");
        sb.append(conseil.getConseil());
        return  sb.toString();
    }
}
