package com.tmo.market.infratructure.repository;

import com.tmo.market.core.entity.Tarifs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifsRepository extends JpaRepository<Tarifs, Long> {
}
