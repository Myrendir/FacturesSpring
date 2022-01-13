package com.app.FacturesSpring.controller;

import com.app.FacturesSpring.model.Facture;
import com.app.FacturesSpring.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/factures/")
public class FactureController {

    @Autowired
    FactureService factureService;

    @GetMapping("")
    public String getFactureById(@RequestParam(name = "id", required = false) Long id, ModelMap modelMap) {
        List<Facture> Factures = new ArrayList<Facture>();
        if (id != null) {
            Facture Facture = factureService.getFactureById(id);
            Factures.add(Facture);
        } else {
            List<Facture> list = factureService.getAllFactures();
            Factures.addAll(list);
        }

        modelMap.addAttribute("Factures", Factures);
        return "facture";
    }

}
