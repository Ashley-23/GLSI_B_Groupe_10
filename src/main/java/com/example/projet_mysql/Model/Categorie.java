package com.example.projet_mysql.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categorie_id")
    private int categorieId;


    @Column(name = "designation", nullable = false)
    private String designation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    private Set<Produit> produits;
}