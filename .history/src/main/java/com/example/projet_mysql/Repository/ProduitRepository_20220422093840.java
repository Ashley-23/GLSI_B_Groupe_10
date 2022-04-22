package com.example.projet_mysql.Repository;

import com.example.projet_mysql.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository <Produit,Integer>{

    @Query("Select p from Produit p where p.libelle like %:n%");

}
