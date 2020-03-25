package com.tmo.market.infratructure.repository;

import com.tmo.market.core.entity.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends JpaRepository<Panier ,Integer> {
}
