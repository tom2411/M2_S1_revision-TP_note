package services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class Compteur {
    private int compteur;

    @PostConstruct
    public void init(){
        compteur = 0;
    }

    public int getCompteur() {
        return compteur;
    }

    public void incrementer() {
        compteur++;
    }
}
