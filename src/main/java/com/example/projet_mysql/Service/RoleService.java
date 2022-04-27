package com.example.projet_mysql.Service;

import com.example.projet_mysql.Model.Role;
import com.example.projet_mysql.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public void saveRole(Role role){
        //Fait l'ajout des rôles
        roleRepository.save(role);
    }

    public void deleteRole(int id){
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (roleOptional.isPresent()){
            roleRepository.deleteById(roleOptional.get().getId());
        }
        else throw new RuntimeException("La suprresion de ce rôle est impossible");
    }

    public List<Role> allRole(){return roleRepository.findAll();}

    public Role oneRole(int id){
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (roleOptional.isPresent()){
            return roleOptional.get();
        }
        throw new RuntimeException("L'identifiant ne correspond à aucun role");
    }
}

/*

public List<Produit> rechercheLibelle(String libelle){return produitRepository.rechercheLibelle(libelle);}
public List<Produit> recherchePrix(String prix){return produitRepository.recherchePrix(prix);}
public List<Produit> recherchedateCreation(String dateCreation){return produitRepository.rechercheDateCreation(dateCreation);}
        }

 */