package com.tmo.market.domaine.usercase;


import com.tmo.market.domaine.entite.ArticleEntity;

public class CalculerPanier {

    ArticleEntity articleEntity;

    public CalculerPanier(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    public double calculerTotalSelected(int nbr){
        return articleEntity.getPrix() * nbr;
    }

    public double augmenterPrix(double prixAdd){
       double result = articleEntity.getPrix() + prixAdd;
       articleEntity.setPrix(result);
       return articleEntity.getPrix();
    }

    public double soustrairePrix(double prixBaisser){
        double result = articleEntity.getPrix() - prixBaisser;
        articleEntity.setPrix(result);
        return articleEntity.getPrix();
    }

    public boolean isZero(){
        return articleEntity.getPrix() == 0;
    }

}
