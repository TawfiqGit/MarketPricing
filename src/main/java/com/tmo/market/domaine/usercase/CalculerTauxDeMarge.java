package com.tmo.market.domaine.usercase;

public class CalculerTauxDeMarge {

    //Taux de marge = (marge commerciale / coût d’achat des produits vendus) x 100
    //Marge commerciale = Chiffre d’affaires HT – Coût d’achat HT
    double chiffreAffaire;
    double coutAchatHT;

    public CalculerTauxDeMarge(double chiffreAffaire, double coutAchatHT) {
        this.chiffreAffaire = chiffreAffaire;
        this.coutAchatHT = coutAchatHT;
    }

    public double calculerMargeCommercial(){
        return chiffreAffaire - coutAchatHT;
    }

    public double calculerTauxMarge(){
        return (calculerMargeCommercial()/ coutAchatHT) * 100;
    }

}
