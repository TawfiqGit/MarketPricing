package com.tmo.market.controller;

import com.tmo.market.MarketApplication;
import com.tmo.market.database.repository.CoutsRepository;
import com.tmo.market.database.repository.ProduitRepository;
import com.tmo.market.domaine.entite.Produit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class MarketController {

    private static final Logger logger = LoggerFactory.getLogger(MarketApplication.class);

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CoutsRepository coutsRepository;

    @GetMapping(value = "/")
    public ResponseEntity<String> main() {
        logger.info("Lancement en cours .....");
        return new ResponseEntity<String>("Réponse du serveur: "+ HttpStatus.OK.name(), HttpStatus.OK);
    }

    @RequestMapping(value = "/produit", method = RequestMethod.GET)
    public List<Produit> showAllProduit(){
        return produitRepository.findAll();
    }

    @GetMapping(value = "/couts")
    public long showAllCout(){
        return coutsRepository.count();
    }

    @PostMapping(value = "/produit")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Produit product) {
        Produit productAdded =  produitRepository.save(product);
        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getNom())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
