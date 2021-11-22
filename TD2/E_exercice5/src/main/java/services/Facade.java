package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
@Service
public class Facade {
    @Autowired
    private Compteur compteur;

    private Map<String,String> users;

    @PostConstruct
    private void fillmap(){
        users=new HashMap<>();
        users.put("alice","alice");
        users.put("bob","bob");
    }


    public boolean checkLP(String login,String password) {
        String pwd=users.get(login);
        return ((pwd!=null) && (pwd.equals(password)));
   }

   public void incrementerCompteurFacade(){
       compteur.incrementer();
   }

   public int getCompteurFacade(){
       return compteur.getCompteur();
   }

}
