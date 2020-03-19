package com.tmo.market.service;

import com.tmo.market.database.repository.TarificationRepository;
import com.tmo.market.domaine.entite.Tarification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarificationService implements TarificationRepository {

    @Override
    public Tarification getTarification(Integer id) {
        return null;
    }

    @Override
    public void ajouterTarification(Tarification tarification) {

    }

    @Override
    public List<Tarification> getAllTarification() {
        return null;
    }

}
