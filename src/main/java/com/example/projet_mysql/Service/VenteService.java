package com.example.projet_mysql.Service;

import com.example.projet_mysql.Model.Vente;
import com.example.projet_mysql.Repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenteService {
    @Autowired
    VenteRepository venteRepository;

    public void saveVente(Vente vente)
    {
       //Fait l'ajout et la modification de la vente
        venteRepository.save(vente);
    }

    public void deleteVente(int id){
        Optional<Vente> venteOptional = venteRepository.findById(id);
        if (venteOptional.isPresent()){
            venteRepository.deleteById(venteOptional.get().getId());
        }
        else throw new RuntimeException("La suppression de cette vente est impossible");
    }

    public List<Vente> allVente(){
        return venteRepository.findAll();
    }

    public Vente oneVente(int id){
        Optional<Vente> venteOptional = venteRepository.findById(id);
        if (venteOptional.isPresent()){
            return venteOptional.get();
        }
        throw new RuntimeException("L'identifiant ne correspond à aucune vente");
    }

   public List<Vente> affichageVenteparProduit(int id){return venteRepository.getProduitIdVente(id);}

    /*

    public List<Produit> rechercheLibelle(String libelle){return produitRepository.rechercheLibelle(libelle);}
    public List<Produit> recherchePrix(String prix){return produitRepository.recherchePrix(prix);}
    public List<Produit> recherchedateCreation(String dateCreation){return produitRepository.rechercheDateCreation(dateCreation);}
}
     */
}