package com.tmo.market.controller;

import com.tmo.market.MarketApplication;
import com.tmo.market.database.repository.ProduitRepository;
import com.tmo.market.domaine.entite.Produit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarketController {

    private static final Logger logger = LoggerFactory.getLogger(MarketApplication.class);

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(value = "/")
    public ResponseEntity<String> main() {
        logger.info("Lancement en cours .....");
        return new ResponseEntity<String>("Réponse du serveur: "+ HttpStatus.OK.name(), HttpStatus.OK);
    }

    @RequestMapping(value = "/market", method = RequestMethod.GET)
    public List<Produit> showPanier(){
        return produitRepository.findAll();
    }

}
