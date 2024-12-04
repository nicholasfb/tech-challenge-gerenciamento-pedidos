package br.com.postech.tech_client.core.repository;

import br.com.postech.tech_client.domain.client.Client;

import java.util.Optional;
import java.util.Set;

public interface ClientRepository {

    Set<Client> findAll();

    Optional<Client> findById(Integer id);

    Client create(Client client);

    Client update(Client client);

}
