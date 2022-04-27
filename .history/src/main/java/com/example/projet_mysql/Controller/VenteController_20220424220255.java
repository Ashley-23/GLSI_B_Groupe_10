package com.example.projet_mysql.Controller;

import java.time.LocalDate;

import com.example.projet_mysql.Model.Client;
import com.example.projet_mysql.Model.Counter;
import com.example.projet_mysql.Model.Produit;
import com.example.projet_mysql.Model.Vente;
import com.example.projet_mysql.Service.ClientService;
import com.example.projet_mysql.Service.ProduitService;
import com.example.projet_mysql.Service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vente")
public class VenteController {
    @Autowired
    VenteService venteService;
    @Autowired
    ProduitService produitService;
    @Autowired
    ClientService clientService;


@GetMapping("/afficher/produit")
    public String afficherallproduit(Model model){
        model.addAttribute("all_vente",venteService.allVente());
        model.addAttribute("all_produit",produitService.allProduit());
        model.addAttribute("all_utilisateur", clientService.allClient());
        model.addAttribute("i", new Counter());
        // System.out.println(venteService.allVente());
        // System.out.println(produitService.allProduit());
         System.out.println(produitService.allProduit());
        return "vente_client/presentation_produit";
    }

    @GetMapping("/{id}/afficher")
    public String afficherallvente(Model model,@PathVariable("id") int id){
        model.addAttribute("all_vente",venteService.allVente());
        model.addAttribute("all_produit",produitService.allProduit());
        model.addAttribute("all_utilisateur", clientService.allClient());
        model.addAttribute("i", new Counter());
        model.addAttribute("one_produit", produitService.oneproduit(id));
        // System.out.println(venteService.allVente());
        // System.out.println(produitService.allProduit());
          System.out.println(venteService.allVente());
          System.out.println(produitService.allProduit());
          System.out.println(clientService.allClient());
        return "vente_client/all";
    }

  @GetMapping("/{id}/renseigner")
    public String renseigner(Model model,@PathVariable("id") int id)
    {
        //model.addAttribute("listCategories",categorieService.showCategories());
        model.addAttribute("all_produit",produitService.allProduit());
        model.addAttribute("all_client",clientService.allClient());
        model.addAttribute("all_vente",venteService.allVente());
        model.addAttribute("one_produit", produitService.oneproduit(id));
       // model.addAttribute("one_produit", produitService.oneproduit(id));
        return "vente_client/add";

        
    }
@PostMapping("/enregistrer")
    public String saveVente(Vente vente, @ModelAttribute("client") Client client, @ModelAttribute("produit")Produit produit)
    {
        //produit.setCategorie(categorie);
        // System.out.println(produit);
        //produit.setDateCreation(LocalDate.now());
       // produit.setQteStock(0);
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);
        vente.setClient(client);
        vente.setProduit(produit);
        return  "redirect:/vente/afficher";

        /*
        produit.setCategorie(categorie);
        System.out.println(produit);
        produit.setDateCreation(LocalDate.now());
        produit.setQteStock(0);
        produitService.saveProduit(produit);
        return  "redirect:/produit/afficher";
        */
    }


    @GetMapping("/{id}/supprimer")
    public String deleteVente(@PathVariable("id") int id)
    {
        venteService.deleteVente(id);
        return "redirect:/produit/{]/afficher";
    }



}

   
/*
   
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