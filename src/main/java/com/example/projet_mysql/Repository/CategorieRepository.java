package com.example.projet_mysql.Repository;

import com.example.projet_mysql.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}