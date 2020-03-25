package com.tmo.market.domaine.entite;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "produit")
@Getter
@Setter
public class Produit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;
    String nom;
    String description;
    double prix_unitaire;
    int quantites;
}
