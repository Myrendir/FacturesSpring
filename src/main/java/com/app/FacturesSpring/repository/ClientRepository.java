package com.app.FacturesSpring.repository;

import com.app.FacturesSpring.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findAll();

    Client findUserById(Long id);

    Client findByFirstname(String string);

    Optional<Client> getUserByEmail(String email);
}
