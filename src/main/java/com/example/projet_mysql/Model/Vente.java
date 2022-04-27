package com.example.projet_mysql.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelleProduit;
    private int qteAchete;
    private int prixUnitaire;
    private LocalDate dateVente;

    // Une vente concerne un seul produit à la fois donc la vente doit prendre l'id de la vente effectué
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    // Une vente concerne une seule personne à la fois donc la vente doit prendre l'id de la personne
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;



}


