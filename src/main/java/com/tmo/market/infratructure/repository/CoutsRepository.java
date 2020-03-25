package com.tmo.market.infratructure.repository;

import com.tmo.market.core.entity.Couts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoutsRepository extends JpaRepository<Couts,Long> {

}
