package com.tmo.market.domaine.usercase;

public class CalculerTotalSommePanier {

    double tarifsDunProduit;
    int quantite;

    public CalculerTotalSommePanier(double tarifsDunProduit, int quantite) {
        this.tarifsDunProduit = tarifsDunProduit;
        this.quantite = quantite;
    }

    public double calculerSommeTotal() {
        return tarifsDunProduit * quantite;
    }
}
