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
import org.springframework.web.bind.annotation.PathVariable;
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
        produit.setCategorie(categorie);
        System.out.println(produit);
        produit.setDateCreation(LocalDate.now());
        produit.setQteStock(0);
        produitService.saveProduit(produit);
        return  "redirect:/produit/afficher";
    }   
// afficher un produit 
    @GetMapping("/{id}/afficherProduit")
    public String afficherUnProduit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("one_produit", produitService.oneproduit(id));
        return "/produit/show";
    }

    
//modifier
    @GetMapping("/{id}/modifier")
    public String modifieProduit(@PathVariable("id") int id, Model model){
        model.addAttribute("one_produit",produitService.oneproduit(id));
        model.addAttribute("all_categorie", categorieService.allCategorie());
        return "/produit/edit";
    }

    //update
   
    @PostMapping("/update")
    public String updateProduit(@ModelAttribute("produit") Produit produit,@ModelAttribute("categorie") Categorie categorie)
    {
       // produit.setCategorie(categorie);
        produitService.saveProduit(produit);
        return "redirect:/produit/afficher";
    }

    @GetMapping("/{id}/supprimer")
    public String deleteProduit(@PathVariable("id") int id, Model model)
    {
        produit
        return "redirect:/produit/show";
    }
    
    /*
    @GetMapping("edit/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("UnProduit", produitService.showOneProduit(id));
        model.addAttribute("UneCategorie", categorieService.showCategories());
        return "/produits/formEdit";
    }

    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("produit") Produit produit){
        produitService.saveProduit((produit));
        return "redirect:/produits/afficher";
    }
    */
    
    
}





