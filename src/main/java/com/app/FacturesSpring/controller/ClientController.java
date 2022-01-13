package com.app.FacturesSpring.controller;

import com.app.FacturesSpring.model.Client;
import com.app.FacturesSpring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/")
    public String getClientById(@RequestParam(name = "id", required = false) Long id, ModelMap modelMap) {
        List<Client> clients = new ArrayList<Client>();
        if (id != null) {
            Client client = clientService.getClientById(id);
            clients.add(client);
        } else {
            List<Client> list = clientService.getAllClient();
            clients.addAll(list);
        }

        modelMap.addAttribute("clients", clients);
        return "client";
    }

    @GetMapping("/clientForm")
    public String showAddClient(Model model) {
        model.addAttribute("client", new Client());

        return "clientForm";
    }

    @PostMapping("/clientForm")
    public ResponseEntity<Client> createClient(@ModelAttribute Client client) {
        Client newClient = clientService.createClient(client);

        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }
}
