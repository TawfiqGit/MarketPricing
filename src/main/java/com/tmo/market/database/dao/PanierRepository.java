package com.tmo.market.database.dao;
import com.tmo.market.domaine.entite.PanierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends JpaRepository<PanierEntity, Long> {


}
