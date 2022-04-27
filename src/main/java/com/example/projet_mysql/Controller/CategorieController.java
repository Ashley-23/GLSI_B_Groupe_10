package com.example.projet_mysql.Controller;

import com.example.projet_mysql.Model.Categorie;
import com.example.projet_mysql.Model.Counter;
import com.example.projet_mysql.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping("/afficher")
    public  String afficherToutCategorie(Model model)
    {
        model.addAttribute("Categories",categorieService.showAllCategorie());
        model.addAttribute("i", new Counter());

        return  "categorie/all";
    }


    @GetMapping("/create")
    public  String afficherFormulaire(){

        return  "categorie/add";
    }
    @PostMapping("/save")
    public  String  save( Categorie categorie){
        categorieService.saveCategorie(categorie);
        return  "redirect:/categorie/afficher";
    }

    // afficher une categorie
    @GetMapping("/{id}/afficherCategorie")
    public String afficherUneCategorie(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("unCategorie", categorieService.showCategorie(id));
        return "categorie/show";
    }




//modifier
    @GetMapping("/{id}/edit")
    public  String formEditCategorie(@PathVariable("id") int id, Model model){

        model.addAttribute("unCategorie",categorieService.showCategorie(id));

        model.addAttribute("Categories",categorieService.showAllCategorie());

        return  "categorie/edit";
    }

    //update
    @PostMapping ("/edit")
    public  String edit(@ModelAttribute("unCategorie" ) Categorie categorie){
        categorieService.saveCategorie(categorie);
        return  "redirect:/categorie/afficher";
    }

    @GetMapping("/{id}/delete")
    public  String delete(@PathVariable("id") int id){

        categorieService.deleteCategorie(id);
        return  "redirect:/categorie/afficher";
    }

}
