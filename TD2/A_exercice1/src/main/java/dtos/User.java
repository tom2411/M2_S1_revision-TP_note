package dtos;

/**
 * La classe User a ici un usage limité : elle sert juste à faire transiter des infos.
 * On pourrait lui attribuer un rôle de stockage, et elle se retrouverait alors dans le modèle.
 * Cette dualité transfert / stockage est souvent utilisée mais elle n'a pas que des avantages...
 * Nous en reparlerons plus tard...
 */
public class User {
    private String login;
    private String surnom;
    private String password;
    private String humeur;

    public User(){}

    public User(String login,String surnom, String password) {
        this.login = login;
        this.surnom = surnom;
        this.password = password;
    }


    public String getHumeur() {
        return humeur;
    }

    public void setHumeur(String humeur) {
        this.humeur = humeur;
    }


    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
