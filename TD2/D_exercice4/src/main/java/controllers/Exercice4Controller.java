package controllers;

import dtos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import services.Compteur;
import services.Facade;

@Controller
@SessionAttributes({"courant","nb"})
@RequestMapping("/")
public class Exercice4Controller {
    @Autowired
    private Facade facade;
    @Autowired
    private Compteur compteur;
    @RequestMapping("")
    public String toLogin(Model model) {
        //ici on doit renvoyer un User du fait du traitement avec modelAttribute et path côté jsp
        model.addAttribute(new User());
        model.addAttribute("nb",String.valueOf(compteur.getCompteur()));
        return("login");
    }

    // on passe un objet user en paramètre : mapping automatique des champs du formulaire
    // on joue aussi avec les messages d'erreurs (BindingResult) ...
    @RequestMapping("login")
    public String checkLP(User user, BindingResult result, Model model){
        if (facade.checkLP(user.getLogin(),user.getPassword())) {
            // on place courant dans le modèle, mais il s'agit d'un attribut de session, il se retrouve ainsi conservé en session
            model.addAttribute("courant",user.getLogin());
            model.addAttribute("username",user.getLogin());
            compteur.incrementer();
            model.addAttribute("nb",String.valueOf(compteur.getCompteur()));
            return "welcome";
        } else {
            // on crée à la volée un "ObjectError" : erreur globale dans l'objet (ici l'objet c'est l'instance de user où transitent les infos de login)
            result.addError(new ObjectError("user","Les informations saisies ne correspondent pas à un utilisateur connu."));
            System.out.println(result.hasErrors());
            compteur.incrementer();
            model.addAttribute("nb",String.valueOf(compteur.getCompteur()));
            // le user du model est renvoyé tel quel à la jsp, et on préserve les valeurs saisies (comment réinitialiser ?)
            return "login";
        }

    }

    @RequestMapping("simplecheck")
    public String simpleCheck(@SessionAttribute String courant,Model model){
        System.out.println(courant);
        model.addAttribute("username",courant);
        compteur.incrementer();
        model.addAttribute("nb",String.valueOf(compteur.getCompteur()));
        return "welcome";
    }

    @RequestMapping("logout")
    public String logout(SessionStatus status,Model model) {
        status.setComplete();
        model.addAttribute(new User());
        compteur.incrementer();
        model.addAttribute("nb",String.valueOf(compteur.getCompteur()));
        return "login";
    }
}
