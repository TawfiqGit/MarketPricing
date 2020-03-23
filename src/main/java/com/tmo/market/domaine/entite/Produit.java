package com.tmo.market.domaine.entite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
@Getter
@Setter
public class Produit extends BaseEntity{
    String nom;
    String description;
    double prix_unitaire;
    int quantites;
    int id_couts;
}
