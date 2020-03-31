package com.tmo.market.entry_point.controlle;

import com.tmo.market.core.entity.*;
import com.tmo.market.core.usercase.*;
import com.tmo.market.infratructure.repository.CoutsRepository;
import com.tmo.market.infratructure.repository.PanierRepository;
import com.tmo.market.infratructure.repository.ProduitRepository;
import com.tmo.market.infratructure.repository.TarifsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @PostMapping(value = "/produits/save")
    public void addProduitWithCouts(Produit produitAdd , Couts coutsAdd ) {
        if (produitAdd.getQuantites() != 0  && !produitAdd.getNom().isEmpty() && produitAdd.getPrix_unitaire() != 0){
            produitRepository.save(produitAdd);
            coutsRepository.save(coutsAdd);
        }
    }

    @GetMapping(value = "/tarifs/save")
    public List<Double> enregistrerTarifs(){
        List<Couts> coutsList = coutsRepository.findAll();
        List<Produit> produitList = produitRepository.findAll();
        List<Tarifs> tarifsList = tarifsRepository.findAll();
        List<Double> tarifCalculerList = new ArrayList<>();
        Tarifs tarifs = new Tarifs();

        for (Couts couts : coutsList){
            for (Produit produit : produitList){
                //Cout revient
                CalculerCoutRevientHT calculerCoutRevientHT = new CalculerCoutRevientHT(couts.getAchat(),couts.getProduction(),couts.getDistribution()
                        ,couts.getPromotion(),couts.getAdministratif(),produit.getQuantites());
                double coutRevient = calculerCoutRevientHT.calculerCoutRevient();
                tarifs.setCoutRevientHt(coutRevient);

                //Taux de marge
                CalculerTauxDeMarge calculerTauxDeMarge = new CalculerTauxDeMarge(1000.0, couts.getAchat());
                double tauxMarge = calculerTauxDeMarge.calculerTauxMarge();
                tarifs.setTauxMarge(tauxMarge);
                tarifs.setId(produit.getId());
                tarifsRepository.save(tarifs);
            }
        }
        for (Tarifs tarifs2 : tarifsList) {
            CalculerPrixVenteHtDunProduit calculerPrixVenteHtDunProduit = new CalculerPrixVenteHtDunProduit(tarifs2.getCoutRevientHt(), tarifs2.getTauxMarge());
            double calculerPrix = calculerPrixVenteHtDunProduit.calculerPrix();
            tarifCalculerList.add(calculerPrix);
        }
        return tarifCalculerList;
    }

    @PostMapping(value = "/panier/save")
    public void addPanier(Panier panierAdd) {
        panierRepository.save(panierAdd);
    }

    @GetMapping(value = "/panier")
    public List<Double> showAllPanier(){
        List<Double> listSommePanier = new ArrayList<>();
        List<Panier> panierList = panierRepository.findAll();

        for (Panier panier : panierList) {
            Optional<Tarifs> tarifsOptional = tarifsRepository.findById(panier.getIdProduit());

            if (tarifsOptional.isPresent()) {
                double coutRevientHt = tarifsOptional.get().getCoutRevientHt();
                double tauxMarge = tarifsOptional.get().getTauxMarge();

                CalculerPrixVenteHtDunProduit calculerPrixVenteHtDunProduit = new CalculerPrixVenteHtDunProduit(coutRevientHt, tauxMarge);
                CalculerTotalSommePanier calculerTotalSommePanier = new CalculerTotalSommePanier(calculerPrixVenteHtDunProduit.calculerPrix(), panier.getQuantite());
                double sommeTotal = calculerTotalSommePanier.calculerSommeTotal();
                listSommePanier.add(sommeTotal);


            }
        }
        return listSommePanier;
    }

   /*@RequestMapping(value = "/option")
    public void checkOptionPresentInPanier(@CookieValue String option) {

    }*/

    @GetMapping(value = "/option")
    public void testOption(int id) {

    }
}
