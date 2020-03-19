package com.tmo.market.database.repository;

import com.tmo.market.domaine.entite.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository  extends JpaRepository<Produit,Long> {
}
