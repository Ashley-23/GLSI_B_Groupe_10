package com.example.projet_mysql.Repository;

import com.example.projet_mysql.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {

}
