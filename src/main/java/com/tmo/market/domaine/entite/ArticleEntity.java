package com.tmo.market.domaine.entite;

import javax.persistence.Entity;

@Entity
public class ArticleEntity extends BaseEntity {

    String nom;
    String description;
    double prix;

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
