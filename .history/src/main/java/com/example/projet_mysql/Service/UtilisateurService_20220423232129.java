package com.example.projet_mysql.Service;

import com.example.projet_mysql.Model.Utilisateur;
import com.example.projet_mysql.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public void saveUtilisateur(Utilisateur utilisateur)
    {
        //Fait l'ajout et la modification de la vente
        utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateur(int id){
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        if (utilisateurOptional.isPresent()){
            utilisateurRepository.deleteById(utilisateurOptional.get().getId());
        }
        else throw new RuntimeException("La suppression de cet utilisateur est impossible");
    }

    public List<Utilisateur> allUtilisateur(){return utilisateurRepository.findAll();}

    public Utilisateur oneUtilisateur(int id){
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        if (utilisateurOptional.isPresent()){
            return  utilisateurOptional.get();
        }
        throw new RuntimeException("L'identifiant ne correspond à aucun utilisateur");
    }

}

