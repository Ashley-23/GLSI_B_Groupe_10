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
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "libelle")
    private String libelle;
    private int prix;
    private int qteStock;
    private int qteSeuil;
    private LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "categorie_id")  //à completer
    private Categorie categorie;
}
