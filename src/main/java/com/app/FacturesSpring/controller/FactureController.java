package com.app.FacturesSpring.controller;

import com.app.FacturesSpring.model.*;
import com.app.FacturesSpring.service.ClientService;
import com.app.FacturesSpring.service.FactureService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/facture")
public class FactureController {

    @Autowired
    FactureService factureService;

    @Autowired
    ClientService clientService;

    @GetMapping("/")
    public String getFactureById(@RequestParam(name = "id", required = false) Long id, ModelMap modelMap) {
        List<Facture> Factures = new ArrayList<Facture>();

        if (id != null) {
            Facture Facture = factureService.getFactureById(id);
            Factures.add(Facture);
        } else {
            List<Facture> list = factureService.getAllFactures();
            Factures.addAll(list);
        }

        modelMap.addAttribute("factures", Factures);
        return "facture";
    }

    @GetMapping("/{dateEmise}")
    public String getFacturesByDate(@RequestParam(name = "dateEmise") String dateEmise, ModelMap modelMap) {
        LocalDate date = LocalDate.parse(dateEmise);
        LocalDate first = date.withDayOfMonth(1);
        LocalDate last = first.plusMonths(1).minusDays(1);
        List<Facture> factureList = factureService.findByDateEmise(first, last);

        String longNameClient = "";
        double tvaSomme = 0;
        double ttc = 0;
        for (Facture facture : factureList) {

            double tva = facture.getTaxe().getTaxe();
            tvaSomme = (facture.getMontant() * (tva / 100));
            ttc = (facture.getMontant() * (1 + (tva / 100)));

            Client client = clientService.getClientById(facture.getClient().getId());
            longNameClient = client.getFirstname() + " " + client.getLastname();
        }

        modelMap.addAttribute("ttc", ttc);
        modelMap.addAttribute("tvaSomme", tvaSomme);
        modelMap.addAttribute("client", longNameClient);
        return "facture";
    }

    @GetMapping("/factureForm")
    public String showAddFacture(Model model) {
        List<Client> clientList = clientService.getAllClient();
        List<TypeFacture> typeFactures = Arrays.asList(TypeFacture.values());
        List<MoyenPaiement> moyenPaiements = Arrays.asList(MoyenPaiement.values());
        List<Taxe> taxes = Arrays.asList(Taxe.values());
        List<StatusFacture> statusFactures = Arrays.asList(StatusFacture.values());

        model.addAttribute("facture", new Facture());
        model.addAttribute("clientList", clientList);
        model.addAttribute("typeFactures", typeFactures);
        model.addAttribute("moyenPaiements", moyenPaiements);
        model.addAttribute("taxes", taxes);
        model.addAttribute("status", statusFactures);

        System.out.println(statusFactures);

        return "factureForm";
    }

    @PostMapping("/factureForm")
    public ResponseEntity<Facture> createFacture(@ModelAttribute Facture facture) {

        Facture newFacture = factureService.createFacture(facture);
        return new ResponseEntity<>(newFacture, HttpStatus.CREATED);
    }

}
