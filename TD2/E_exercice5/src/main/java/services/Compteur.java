package services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Compteur {

    private int compteur;

    @PostConstruct
    public void init() {
        compteur = 0;
    }

    public int incrementer() {
        return compteur++;
    }

    public int getCompteur() {
        return compteur;
    }

}
