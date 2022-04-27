package com.example.projet_mysql.Controller;

import com.example.projet_mysql.Model.*;
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
        model.addAttribute("all_client",clientService.allClient());
        model.addAttribute("i", new Counter());
        model.addAttribute("libelle", libelle);
        // System.out.println(clientService.allProduit());

        return "client/all";
    }


    @GetMapping("/renseigner")
    public String renseigner(Model model)
    {
        //model.addAttribute("listCategories",categorieService.showCategories());
        return "client/add";
    }

    @PostMapping("/enregistrer")
    public String saveClient(Client client)
    {
        clientService.saveClient(client);
        return  "redirect:/client/afficher";
    }
    // afficher un produit
    @GetMapping("/{id}/afficherClient")
    public String afficherUnClient(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("one_client", clientService.oneClient(id));
        return "/client/show";
    }


    //modifier
    @GetMapping("/{id}/modifier")
    public String modifierClient(@PathVariable("id") int id, Model model){
        model.addAttribute("one_produit",clientService.oneClient(id));
        return "/client/edit";
    }

    //update

    @PostMapping("/update")
    public String updateClient(@ModelAttribute("client") Client client)
    {
        clientService.saveClient(client);
        return "redirect:/client/afficher";
    }

    @GetMapping("/{id}/supprimer")
    public String deleteClient(@PathVariable("id") int id)
    {
        clientService.deleteClient(id);
        return "redirect:/client/afficher";
    }
/*
    public String RechercheLibelle(@ModelAttribute("libelle") String libelle,Model model){
        model.addAttribute("all_produit",clientService.rechercheLibelle(libelle));
        return "";
    }
*/

}
