package com.tmo.market.controller;

import com.tmo.market.database.repository.CoutsRepository;
import com.tmo.market.database.repository.PanierRepository;
import com.tmo.market.database.repository.ProduitRepository;
import com.tmo.market.database.repository.TarifsRepository;
import com.tmo.market.domaine.entite.Couts;
import com.tmo.market.domaine.entite.Panier;
import com.tmo.market.domaine.entite.Produit;
import com.tmo.market.domaine.entite.Tarifs;
import com.tmo.market.domaine.usercase.CalculerCoutRevientHT;
import com.tmo.market.domaine.usercase.CalculerPrixVenteHtDunProduit;
import com.tmo.market.domaine.usercase.CalculerTauxDeMarge;
import com.tmo.market.domaine.usercase.CalculerTotalSommePanier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MarketController {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CoutsRepository coutsRepository;
    @Autowired
    private TarifsRepository tarifsRepository;
    @Autowired
    private PanierRepository panierRepository;

    @DeleteMapping
    public void deleteAll(){
        produitRepository.deleteAll();
        coutsRepository.deleteAll();
        tarifsRepository.deleteAll();
    }

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

                tarifs.setId(produit.getId());
                System.out.println("ID Tarifs" +tarifs.getId());
                System.out.println("ID Produit" +produit.getId());
                tarifsRepository.save(tarifs);
            }
        }
    }

    @GetMapping(value = "/tarifs/vente")
    public List<Double> showAllTarifsCaculer(){
        List<Tarifs> tarifsList = tarifsRepository.findAll();
        List<Double> tarifCalculerList = new ArrayList<>();

        for (Tarifs tarifs : tarifsList){
            CalculerPrixVenteHtDunProduit calculerPrixVenteHtDunProduit = new CalculerPrixVenteHtDunProduit(tarifs.getCoutRevientHt(),tarifs.getTauxMarge());
            double calculerPrix = calculerPrixVenteHtDunProduit.calculerPrix();
            tarifCalculerList.add(calculerPrix);
        }
        return tarifCalculerList;
    }

    @PostMapping(value = "/panier")
    public void addPanier(Panier panierAdd) {
        panierRepository.save(panierAdd);
    }

    @GetMapping(value = "/panier/")
    public List<Double> showAllPanier(){
        List<Double> listSommePanier = new ArrayList<>();
        List<Panier> panierList = panierRepository.findAll();

        for (Panier panier : panierList) {

            Optional<Tarifs> tarifsOptional = tarifsRepository.findById(panier.getIdProduit());

            if (tarifsOptional.isPresent()) {

                double coutRevientHt = tarifsOptional.get().getCoutRevientHt();
                double tauxMarge = tarifsOptional.get().getTauxMarge();

                CalculerPrixVenteHtDunProduit calculerPrixVenteHtDunProduit = new CalculerPrixVenteHtDunProduit(coutRevientHt, tauxMarge);
                double calculerPrix = calculerPrixVenteHtDunProduit.calculerPrix();

                CalculerTotalSommePanier calculerTotalSommePanier = new CalculerTotalSommePanier(calculerPrix, panier.getQuantite());
                double sommeTotal = calculerTotalSommePanier.calculerSommeTotal();

                listSommePanier.add(sommeTotal);
            }
        }
        return listSommePanier;
    }
}
