package com.example.projet_mysql.Controller;

import com.example.projet_mysql.Repository.CategorieRepository;
import com.example.projet_mysql.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    CategorieService categorieService;
    @GetMapping("/afficher")
    public String afficherAllCategorie(Model model) {
        model.addAttribute("all_categorie",categorieService.allCategorie());
        System.out.println(categorieService.allCategorie());
        return "";
    }
}
