package com.tmo.market.database.repository;

import com.tmo.market.domaine.entite.Tarification;
import jdk.jfr.Registered;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarificationRepository    {

    Tarification getTarification(Integer id);

    void ajouterTarification(Tarification tarification);

    List<Tarification> getAllTarification();


}
