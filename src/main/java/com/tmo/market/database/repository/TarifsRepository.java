package com.tmo.market.database.repository;

import com.tmo.market.domaine.entite.Tarifs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifsRepository extends JpaRepository<Tarifs, Integer> {
}
