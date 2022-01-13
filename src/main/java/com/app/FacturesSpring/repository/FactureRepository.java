package com.app.FacturesSpring.repository;

import com.app.FacturesSpring.model.Facture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FactureRepository extends CrudRepository<Facture, Long> {

    List<Facture> findAll();

    Facture findFactureById(Long id);

    Optional<Facture> getFactureByReference(String reference);

}
