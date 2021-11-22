package services;

import dtos.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Facade {
    private static Facade instance=null;

    private Map<String,User> users;
    private ArrayList<String> humeurs;

    private Facade(){
        users=new HashMap<>();

        User u1=new User("vivi","Miss Wednesday","alice");
        User u2=new User("bob","Bob Dylan","bob");

        users.put(u1.getLogin(),u1);
        users.put(u2.getLogin(),u2);

        humeurs=new ArrayList<>();

        humeurs.add("déséspérer");
        humeurs.add("triste");
        humeurs.add("content");
        humeurs.add("heureux");
        humeurs.add("SHEESH");



    }

    public static synchronized Facade getInstance() {
        if (instance==null) {
            instance=new Facade();
        }
        return instance;
    }

    public boolean checkLP(String login,String password) {
        User user=users.get(login);
        return ((user.getPassword()!=null) && (user.getPassword().equals(password)));
   }

    public Object getHumeurs() {
        return humeurs;
    }
}
