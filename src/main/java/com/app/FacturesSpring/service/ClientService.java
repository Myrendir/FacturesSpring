package com.app.FacturesSpring.service;

import com.app.FacturesSpring.exception.ClientAlreadyExistException;
import com.app.FacturesSpring.model.Client;
import com.app.FacturesSpring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client getClientByEmail(String email) throws ClientAlreadyExistException {
        Optional<Client> optUser = clientRepository.getUserByEmail(email);
        if (!optUser.isPresent()) {
            Client user = new Client(email);
            return clientRepository.save(user);
        } else {
            throw new ClientAlreadyExistException("User at email: " + email + " already exist");
        }
    }

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findUserById(id);
    }
}
