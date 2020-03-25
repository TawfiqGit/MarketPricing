package com.tmo.market.database.repository;

import com.tmo.market.domaine.entite.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends JpaRepository<Panier ,Integer> {
}
