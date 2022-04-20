package com.example.projet_mysql.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categorie {

    @Id
    @GeneratedValue()
    private int id;

}
