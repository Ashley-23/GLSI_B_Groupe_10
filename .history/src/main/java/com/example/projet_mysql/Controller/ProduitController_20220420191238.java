package com.example.projet_mysql.Controller;


import com.example.projet_mysql.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("produit")
public class ProduitController {
    @Autowired
    ProduitService produitService;

    @GetMapping("/afficher")
    public String afficheVue(Model model){
        model.addAttribute("allproduit",produitService.allProduit());
        System.out.println(produitService.allProduit);
        return "produit/produitVue";
    }
}
