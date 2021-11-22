package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.inject.Inject;

import services.*;

@Controller
@RequestMapping("/")
public class FirstController {
    // l'ambiguité est résolue par nom de la variable (qualifier implicite)
    @Autowired
    private Service1 service1Impl1;

    // l'ambiguité est résolue par qualifier explicite
    @Autowired
    @Qualifier("english")
    private Service1 service1;

    // Là pas d'ambiguité, une seule lasse implémente le service
    @Autowired
    private Service2 service2;

    // Service2 est spécial : scope prototype : ce n'est pas un singleton
    @Autowired
    private Service2 service2Autre;


    // Pas de problème, le service est une classe sans interface...
    @Autowired
    private Service3 service3;

    // Pour comparer avec Service2, on fait deux injections de Service 3
    @Autowired
    private Service3 service3Autre;

    // Utilisation inject plutôt que autowired
    @Inject
    private Service5 service5;

    @Autowired
    private Service7 service7;


    // Cette resource est définie dans ResourceConfig. L'intérêt est d'injecter par name...
    // ce qui fait sens quand on utilise des types "simples" comme String...
    @Resource(name = "motdujour")
    String motdj;


    @RequestMapping("")
    public String render(Model model){
        String nom="Toto";
        model.addAttribute("message1", service1Impl1.hello(nom));
        model.addAttribute("message1bis", service1.hello(nom));
        model.addAttribute("message2", service2.reverse(nom));
        model.addAttribute("message3", service3.codeUnique());
        model.addAttribute("message5", service5.doIt());

        model.addAttribute("message6", motdj);

        model.addAttribute("message7", service7.codeUnique());


        model.addAttribute("service2Id",service2.toString());
        model.addAttribute("service2AutreId",service2Autre.toString());

        model.addAttribute("service3Id",service3.toString());
        model.addAttribute("service3AutreId",service3Autre.toString());

        return "first";
    }
}
