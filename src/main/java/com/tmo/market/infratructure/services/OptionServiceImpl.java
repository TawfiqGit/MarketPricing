package com.tmo.market.infratructure.services;

import com.tmo.market.core.entity.OptionSelected;
import com.tmo.market.core.entity.Options;
import com.tmo.market.core.entity.Panier;
import com.tmo.market.core.entity.Produit;
import com.tmo.market.infratructure.repository.PanierRepository;
import com.tmo.market.infratructure.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OptionServiceImpl implements OptionService{
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    PanierRepository panierRepository;

    @Override
    public Collection<Produit> get() {
        return null;
    }

    @Override
    public boolean verifierQuantiteProduit(Panier panier) {
        List<Produit> produitsList = produitRepository.findAll();
        for (Produit produit : produitsList){
            if (panier.getIdProduit() == produit.getId()){
                int quantite = panier.getQuantite();
                if (quantite == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public double reductionProduit(int id) {

        return 0;
    }
}
