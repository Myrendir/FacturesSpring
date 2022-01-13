package com.app.FacturesSpring.controller;

import com.app.FacturesSpring.model.Client;
import com.app.FacturesSpring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/client/")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("")
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

    @GetMapping(value = "addclient")
    public String clientSubmit(Model model) {
        model.addAttribute("client", new Client());
        return "addclient";
    }

    @PostMapping(value = "addclient")
    public String clientSubmit(@ModelAttribute Client client, Model model) {
        model.addAttribute("client", client);
        return "result";
    }

}
