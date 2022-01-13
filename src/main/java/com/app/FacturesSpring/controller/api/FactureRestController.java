package com.app.FacturesSpring.controller.api;

import com.app.FacturesSpring.model.Facture;
import com.app.FacturesSpring.repository.FactureRepository;
import com.app.FacturesSpring.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FactureRestController {
    @Autowired
    FactureService factureService;

    @GetMapping("/factures")
    public ResponseEntity<List<Facture>> getAllClients() {
        return new ResponseEntity<List<Facture>>(factureService.getAllFactures(), HttpStatus.OK);
    }

    @PostMapping("/factures")
    public ResponseEntity<Facture> createFacture(@Valid @RequestBody Facture facture) {
        Facture newFacture = factureService.createFacture(facture);
        return new ResponseEntity<Facture>(newFacture, HttpStatus.CREATED);
    }
}
