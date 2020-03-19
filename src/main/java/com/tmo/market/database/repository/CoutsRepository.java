package com.tmo.market.database.repository;

import com.tmo.market.domaine.entite.Couts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoutsRepository extends JpaRepository<Couts,Long> {

}
