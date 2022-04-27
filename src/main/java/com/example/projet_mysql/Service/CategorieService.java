package com.example.projet_mysql.Service;

import com.example.projet_mysql.Model.Categorie;
import com.example.projet_mysql.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    @Autowired
  private CategorieRepository categorieRepository;
    //Pour l'ajout et la modification des catégories
    public void saveCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }

    //Pour la suppression des catégories
    public void deleteCategorie(int id) {
        Optional<Categorie> categorieOptional = categorieRepository.findById(id);
        if (categorieOptional.isPresent()){
            categorieRepository.deleteById(categorieOptional.get().getCategorieId());
        }
       else throw new RuntimeException("La catégorie à supprimer est introuvable");
    }

    //Pour afficher la liste de toutes les catégories

    public List<Categorie> showAllCategorie(){
         return categorieRepository.findAll();
    }

    //Pour afficher une catégorie en particulier

    public Categorie showCategorie(int id)
    {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        if (optionalCategorie.isPresent()){
            return optionalCategorie.get();
        }
        throw new RuntimeException("La catégorie recherchée est introuvable");
    }
}

