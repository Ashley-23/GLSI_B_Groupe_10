package com.example.projet_mysql.Repository;

import java.util.List;

import com.example.projet_mysql.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository <Produit,Integer>{

    @
    @Query("Select p from Produit p where p.libelle like %:n%")
    List<Produit> rechercheLibelle(@Param("n") String libelle);

    @Query("Select p from Produit p where p.dateCreation like %:n%")
    List<Produit> rechercheDateCreation(@Param("n") String dateCreation);

    @Query("Select p from Produit p where p.prix like %:n%")
    List<Produit> recherchePrix(@Param("n") String prix);
}
