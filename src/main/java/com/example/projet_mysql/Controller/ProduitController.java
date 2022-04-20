package com.example.projet_mysql.Controller;

import com.example.projet_mysql.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduitController {
    @Autowired
    ProduitRepository produitRepository;
    @GetMapping("/produit/afficher")
    public String afficheVue(){
        return "produitVue";
    }
}
