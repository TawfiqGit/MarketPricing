package com.tmo.market.controller;

import com.tmo.market.database.repository.CoutsRepository;
import com.tmo.market.database.repository.ProduitRepository;
import com.tmo.market.database.repository.TarifsRepository;
import com.tmo.market.domaine.entite.Couts;
import com.tmo.market.domaine.entite.Produit;
import com.tmo.market.domaine.entite.Tarifs;
import com.tmo.market.domaine.usercase.CalculerCoutRevientHT;
import com.tmo.market.domaine.usercase.CalculerTauxDeMarge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketController {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CoutsRepository coutsRepository;
    @Autowired
    private TarifsRepository tarifsRepository;

    @PostMapping(value = "/clients")
    public void addCustomer(Produit produitAdd , Couts coutsAdd ) {
        if (produitAdd.getQuantites() != 0  && !produitAdd.getNom().isEmpty() && produitAdd.getPrix_unitaire() != 0){
            produitRepository.save(produitAdd);
            coutsRepository.save(coutsAdd);
        }
    }

    @GetMapping(value = "/couts")
    public List<Couts> showAllCout(){
        return coutsRepository.findAll();
    }

    @RequestMapping(value = "/produit", method = RequestMethod.GET)
    public List<Produit> showAllProduit(){
        return produitRepository.findAll();
    }

    @GetMapping(value = "/tarifs")
    public List<Tarifs> showAllTarifs(){
        return tarifsRepository.findAll();
    }

    @GetMapping(value = "/tarifs/save")
    public void saveTarifs(){
        List<Couts> coutsList = coutsRepository.findAll();
        List<Produit> produitList = produitRepository.findAll();
        Tarifs tarifs = new Tarifs();

        for (Couts couts : coutsList){
            for (Produit produit : produitList){

                System.out.println("Produit getQuantite= " +produit.getQuantites());
                System.out.println("Couts getAchat = " +couts.getAchat());
                System.out.println("Couts getDistribution = " +couts.getDistribution());
                System.out.println("Couts getProduction = " +couts.getProduction());
                System.out.println("Couts getPromotion = " +couts.getPromotion());
                System.out.println("Couts getAdministratif = " +couts.getAdministratif());

                //Cout revient
                CalculerCoutRevientHT calculerCoutRevientHT = new CalculerCoutRevientHT(couts.getAchat(),couts.getProduction()
                        ,couts.getDistribution(),couts.getPromotion(),couts.getAdministratif(),produit.getQuantites());
                double coutRevient = calculerCoutRevientHT.calculerCoutRevient();
                tarifs.setCoutRevientHt(coutRevient);
                System.out.println("Cout Revient = " +coutRevient);


                //Taux de marge
                CalculerTauxDeMarge calculerTauxDeMarge = new CalculerTauxDeMarge(1000.0, couts.getAchat());
                double tauxMarge = calculerTauxDeMarge.calculerTauxMarge();
                tarifs.setTauxMarge(tauxMarge);
                System.out.println("Taux de marge = " +tauxMarge);

                tarifsRepository.save(tarifs);
            }
        }
    }
}
