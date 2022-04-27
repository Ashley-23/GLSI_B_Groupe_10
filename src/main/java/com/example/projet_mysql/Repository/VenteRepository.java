package com.example.projet_mysql.Repository;

import com.example.projet_mysql.Model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Integer>{

    @Transactional
            @Query(value = "select * from vente where vente.produit_id=:id",nativeQuery = true)

    List<Vente> getProduitIdVente(int id);

}


    //@Query(value ="select * from vente where vente.produit_id=:id",nativeQuery = true);
    //select * from vente where vente.produit_id=2;
    /*
        @Transactional
    @Query("Select p from Produit p where p.libelle like %:n%")
    List<Produit> rechercheLibelle(@Param("n") String libelle);
    */


