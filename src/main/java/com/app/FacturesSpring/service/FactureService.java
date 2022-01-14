package com.app.FacturesSpring.service;

import com.app.FacturesSpring.exception.facture.FactureAlreadyExistException;
import com.app.FacturesSpring.model.Facture;
import com.app.FacturesSpring.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FactureService {
    @Autowired
    FactureRepository factureRepository;

    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    public Facture getFactureById(Long id) {
        return factureRepository.findFactureById(id);
    }

    public Facture getFactureByReference(String reference) throws FactureAlreadyExistException {
        Optional<Facture> optFacture = factureRepository.getFactureByReference(reference);
        if (!optFacture.isPresent()) {
            Facture facture = new Facture(reference);
            return factureRepository.save(facture);
        } else {
            throw new FactureAlreadyExistException("Facture at reference " + reference + " already exists");
        }
    }

    public Facture createFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    public List<Facture> findByDateEmise(LocalDate first, LocalDate last) {
        return factureRepository.findByDateEmise(first,last);
    }
}
