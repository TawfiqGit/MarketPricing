package com.tmo.market.domaine.usercase;

public class CalculerPrixVenteHtDunProduit {

    //Formule = coutRevient + tauxMarge
    double cout_revient_ht;
    double taux_marge;

    public CalculerPrixVenteHtDunProduit(double cout_revient_ht, double taux_marge) {
        this.cout_revient_ht = cout_revient_ht;
        this.taux_marge = taux_marge;
    }

    public double calculerPrix(){
        return cout_revient_ht + taux_marge;
    }
}
