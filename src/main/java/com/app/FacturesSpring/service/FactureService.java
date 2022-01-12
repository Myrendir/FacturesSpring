package com.app.FacturesSpring.service;

import com.app.FacturesSpring.model.Facture;
import com.app.FacturesSpring.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FactureService {
    @Autowired
    FactureRepository factureRepository;

    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    public Facture getFactureById(Long id) {
        return factureRepository.findFactureById(id);
    }

    public Facture getFactureByReference(String reference) {
        return factureRepository.findByReference(reference);
    }

}
