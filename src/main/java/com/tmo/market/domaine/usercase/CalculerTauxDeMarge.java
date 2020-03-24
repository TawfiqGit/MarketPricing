package com.tmo.market.domaine.usercase;

//TODO : a voir taux de marque & coef multiple
//Taux de marque = (Marge commerciale HT / Prix de vente HT) x 100.
//Coefficient multiplicateur = Prix de vente TTC / Prix de vente HT.
public class CalculerTauxDeMarge {

    double chiffreAffaire;
    double coutAchatHT;

    public CalculerTauxDeMarge(double chiffreAffaire, double coutAchatHT) {
        this.chiffreAffaire = chiffreAffaire;
        this.coutAchatHT = coutAchatHT;
    }

    private double calculerMargeCommercial(){
        return chiffreAffaire - coutAchatHT;
    }

    public double calculerTauxMarge(){
        return (calculerMargeCommercial()/ coutAchatHT) * 100;
    }
}
