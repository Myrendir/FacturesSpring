package com.app.FacturesSpring.repository;

import com.app.FacturesSpring.model.Facture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FactureRepository extends CrudRepository<Facture, Long> {

    List<Facture> findAll();
    Facture findFactureById(Long id);
    Facture findByReference(String reference);

}
