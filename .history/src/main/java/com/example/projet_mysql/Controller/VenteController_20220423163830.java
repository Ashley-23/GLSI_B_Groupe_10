package com.example.projet_mysql.Controller;

import com.example.projet_mysql.Model.Counter;
import com.example.projet_mysql.Service.ProduitService;
import com.example.projet_mysql.Service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vente")
public class VenteController {
    @Autowired
    VenteService venteService;
    @Autowired
    ProduitService produitService;
    

@GetMapping("/afficher/produit")
    public String afficherallproduit(Model model){
        model.addAttribute("all_vente",venteService.allVente());
        model.addAttribute("all_produit",produitService.allProduit());
        model.addAttribute("all_utilisateur", utilisate)
        model.addAttribute("i", new Counter());
        // System.out.println(venteService.allVente());
        // System.out.println(produitService.allProduit());
        return "vente_client/presentation_produit";
    }

    @GetMapping("/afficher")
    public String afficherallvente(Model model){
        model.addAttribute("all_vente",venteService.allVente());
        model.addAttribute("all_produit",produitService.allProduit());
        model.addAttribute("all_utilisateur", utilisate)
        model.addAttribute("i", new Counter());
        // System.out.println(venteService.allVente());
        // System.out.println(produitService.allProduit());
        return "vente_client/all";
    }

    @GetMapping("/renseigner")
    public String renseignervente(Model model){
    model.addAttribute("all_produit",produitService.allProduit());
    return "vente/add";
    }
}
/*
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
        // System.out.println(produit);
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
    public String updateProduit(@ModelAttribute("produit") Produit produit)
    {
       // produit.setCategorie(categorie);
        produitService.saveProduit(produit);
        return "redirect:/produit/afficher";
    }

    @GetMapping("/{id}/supprimer")
    public String deleteProduit(@PathVariable("id") int id)
    {
        produitService.deleteProduit(id);
        return "redirect:/produit/afficher";
    }

    public String RechercheLibelle(@ModelAttribute("libelle") String libelle,Model model){
        model.addAttribute("all_produit",produitService.rechercheLibelle(libelle));
        return "";
    }
 */