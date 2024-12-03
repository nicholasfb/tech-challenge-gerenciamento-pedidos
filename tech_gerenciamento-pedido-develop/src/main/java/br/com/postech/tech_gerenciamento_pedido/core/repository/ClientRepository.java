package br.com.postech.tech_gerenciamento_pedido.core.repository;

import br.com.postech.tech_gerenciamento_pedido.domain.client.Client;

import java.util.Optional;
import java.util.Set;

public interface ClientRepository {

    Set<Client> findAll();

    Optional<Client> findById(Integer id);

    Client create(Client client);

    Client update(Client client);

}
