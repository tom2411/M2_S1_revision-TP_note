package services;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


// Suivant le scope on peut observer des comportements différents...
@Service
@Scope("prototype")
public class Service2Impl implements Service2{
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
