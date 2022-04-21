package com.example.projet_mysql.Controller;


import com.example.projet_mysql.Model.Categorie;
import com.example.projet_mysql.Model.Produit;
import com.example.projet_mysql.Service.CategorieService;
import com.example.projet_mysql.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("produit")
public class ProduitController {
    @Autowired
    ProduitService produitService;
    @Autowired
    CategorieService categorieService;


    @GetMapping("/afficher")
    public String afficheallproduit(Model model){
        model.addAttribute("all_produit",produitService.allProduit());
        System.out.println(produitService.allProduit());
        return "produit/all";
    }


     @GetMapping("/renseigner")
    public String renseigner(Model model)
    {
        //model.addAttribute("listCategories",categorieService.showCategories());
        model.addAttribute("all_categorie",categorieService.allCategorie());
        return "produit/add";
    }

@PostMapping("/enregistrer")
    public String saveProduit(Produit produit,@ModelAttribute("categorie") Categorie categorie)
    {
        p
        System.out.println(produit);
        produit.setDateCreation(LocalDate.now());
        produit.setQteSeuil(0);
        produitService.saveProduit(produit);
        return  "redirect:/produit/afficher";
    }

    
   /*
    @PostMapping("/save")
    public String saveProduit(Produit produit)
    {

        produit.setDateCreation(LocalDate.now());
        produit.setQtStock(0);
        produitService.saveProduit(produit);
        return "redirect:/produits/afficher";
    }
    */
    
}





