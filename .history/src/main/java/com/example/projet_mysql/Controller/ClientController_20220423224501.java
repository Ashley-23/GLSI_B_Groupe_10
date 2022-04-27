package com.example.projet_mysql.Controller;

import com.example.projet_mysql.Model.Categorie;
import com.example.projet_mysql.Model.Counter;
import com.example.projet_mysql.Model.Produit;
import com.example.projet_mysql.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    ClientService clientService;






    @GetMapping("/afficher")
    public String afficheallclient(Model model, @Param("n") String libelle){
        model.addAttribute("all_produit",clientService.allProduit());
        model.addAttribute("i", new Counter());
        model.addAttribute("libelle", libelle);
        // System.out.println(clientService.allProduit());

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
    public String saveClient(Produit produit, @ModelAttribute("categorie") Categorie categorie)
    {
        produit.setCategorie(categorie);
        // System.out.println(produit);
        produit.setDateCreation(LocalDate.now());
        produit.setQteStock(0);
        clientService.saveProduit(produit);
        return  "redirect:/produit/afficher";
    }
    // afficher un produit
    @GetMapping("/{id}/afficherProduit")
    public String afficherUnClient(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("one_produit", clientService.oneproduit(id));
        return "/produit/show";
    }


    //modifier
    @GetMapping("/{id}/modifier")
    public String modifierClient(@PathVariable("id") int id, Model model){
        model.addAttribute("one_produit",clientService.oneproduit(id));
        model.addAttribute("all_categorie", categorieService.allCategorie());
        return "/produit/edit";
    }

    //update

    @PostMapping("/update")
    public String updateClient(@ModelAttribute("produit") Produit produit)
    {
        // produit.setCategorie(categorie);
        clientService.saveProduit(produit);
        return "redirect:/produit/afficher";
    }

    @GetMapping("/{id}/supprimer")
    public String deleteClient(@PathVariable("id") int id)
    {
        clientService.deleteProduit(id);
        return "redirect:/produit/afficher";
    }
/*
    public String RechercheLibelle(@ModelAttribute("libelle") String libelle,Model model){
        model.addAttribute("all_produit",produitService.rechercheLibelle(libelle));
        return "";
    }
*/

}
