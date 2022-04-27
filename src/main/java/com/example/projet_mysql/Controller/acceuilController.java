package com.example.projet_mysql.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("accueil")
public class acceuilController {

    @GetMapping("")
    public String accueil(){
        return "authentification/accueil";
    }
}
