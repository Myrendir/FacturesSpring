package com.app.FacturesSpring.repository;

import com.app.FacturesSpring.model.Facture;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FactureRepository extends CrudRepository<Facture, Long> {

    List<Facture> findAll();

    Facture findFactureById(Long id);

    Optional<Facture> getFactureByReference(String reference);

    List<Facture> findByDateEmise(LocalDate date1, LocalDate date2);


}
