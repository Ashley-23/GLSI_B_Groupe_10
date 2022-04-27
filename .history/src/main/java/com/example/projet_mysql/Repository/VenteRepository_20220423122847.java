package com.example.projet_mysql.Repository;

import com.example.projet_mysql.Model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Integer>{
}

