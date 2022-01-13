package com.app.FacturesSpring.controller.api;

import com.app.FacturesSpring.model.Client;
import com.app.FacturesSpring.service.ClientService;
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
public class ClientRestController {
    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<List<Client>>(clientService.getAllClient(), HttpStatus.OK);
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
        Client newClient = clientService.createClient(client);
        return new ResponseEntity<Client>(newClient, HttpStatus.CREATED);
    }
}
