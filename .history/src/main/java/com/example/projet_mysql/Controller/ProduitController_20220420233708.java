package com.example.projet_mysql.Controller;


import com.example.projet_mysql.Model.Produit;
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
    public String afficheallproduit(Model model){
        model.addAttribute("all_produit",produitService.allProduit());
        // System.out.println(produitService.allProduit());
        return "produit/all";
    }


     @GetMapping("/renseigner")
    public String renseigner()
    {
        return "produit/add";
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





