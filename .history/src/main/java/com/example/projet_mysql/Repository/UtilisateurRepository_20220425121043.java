package com.example.projet_mysql.Repository;

import com.example.projet_mysql.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
   // Optional<Utilisateur> findByUserName(String nom);
}
