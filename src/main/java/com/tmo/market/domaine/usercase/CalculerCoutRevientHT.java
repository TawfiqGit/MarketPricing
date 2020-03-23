package com.tmo.market.domaine.usercase;

public class CalculerCoutRevientHT {

    //Formule = somme des charges directes et indirectes / quantités produites.
    double cout_achat;
    double cout_production;
    double cout_distribution;
    double cout_promotion;
    double cout_administratif;
    int quantit_produit;

    public CalculerCoutRevientHT(double cout_achat, double cout_production, double cout_distribution, double cout_promotion, double cout_administratif, int quantit_produit) {
        this.cout_achat = cout_achat;
        this.cout_production = cout_production;
        this.cout_distribution = cout_distribution;
        this.cout_promotion = cout_promotion;
        this.cout_administratif = cout_administratif;
        this.quantit_produit = quantit_produit;
    }

    public double calculerCoutRevient(){
        return (cout_achat + cout_production + cout_distribution + cout_promotion + cout_administratif) / quantit_produit;
    }
}
