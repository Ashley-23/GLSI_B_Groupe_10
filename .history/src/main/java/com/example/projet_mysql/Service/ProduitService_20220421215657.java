package com.example.projet_mysql.Service;

import com.example.projet_mysql.Model.Produit;
import com.example.projet_mysql.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    ProduitRepository produitRepository;

    public void saveProduit(Produit produit) {
        // Fait l'ajout et la modification du produit

        produitRepository.save(produit);
    }

    public void deleteProduit(int id) {
        // produitRepository.delete(produit);
        System.out.println(id+"Ceci est l'id");
        Optional<Produit> produitOptional = produitRepository.findById(id);
        System.out.println(produitOptional.get()+"Ceci est le produit sélectionné");
        if (produitOptional.isPresent()) {
            System.out.println("Nous sommes effectivement dans la boucle\n"+produitOptional.get().getId()+"\nVoici le'id du produit qui sera supprimé");
            produitRepository.deleteById(produitOptional.get().getId());
        } 
        throw new RuntimeException("La suppression de ce produit est impossible");

    }

    public List<Produit> allProduit() {
        return produitRepository.findAll();
    }

    public Produit oneproduit(int id) {
        Optional<Produit> produitOptional = produitRepository.findById(id);
        if (produitOptional.isPresent()) {
            /*
             * Produit produit;
             * produit = produitOptional.get();
             * return produit;
             */
            return produitOptional.get();
        }
        throw new RuntimeException("L'identifiant ne correspond à aucun produit");
    }
}
