package com.tmo.market.infratructure.services;

import com.tmo.market.core.entity.Options;
import com.tmo.market.core.entity.Panier;
import com.tmo.market.core.entity.Produit;

import java.util.Collection;

public interface OptionService {

    Collection<Produit> get();
    boolean verifierQuantiteProduit(Panier panier);
    double reductionProduit(int id);
}
