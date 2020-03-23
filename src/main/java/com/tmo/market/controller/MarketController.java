package com.tmo.market.controller;

import com.tmo.market.database.repository.CoutsRepository;
import com.tmo.market.database.repository.ProduitRepository;
import com.tmo.market.domaine.entite.Couts;
import com.tmo.market.domaine.entite.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketController {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CoutsRepository coutsRepository;

    @PostMapping(value = "/clients/produit")
    public void addCustomerProduit(Produit produitAdd ){
        produitRepository.save(produitAdd);
    }

    @PostMapping(value = "/clients/couts")
    public void addCustomerCouts(Couts coutsAdd){
        coutsRepository.save(coutsAdd);
    }

    @GetMapping(value = "/couts")
    public List<Couts> showAllCout(){
        return coutsRepository.findAll();
    }

    @RequestMapping(value = "/produit", method = RequestMethod.GET)
    public List<Produit> showAllProduit(){
        return produitRepository.findAll();
    }
}
