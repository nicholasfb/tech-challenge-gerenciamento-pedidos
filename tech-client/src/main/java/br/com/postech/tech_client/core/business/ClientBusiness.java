package br.com.postech.tech_client.core.business;

import br.com.postech.tech_client.domain.client.Client;

import java.util.Set;

public interface ClientBusiness {

    Set<Client> getClients();

    Client getClient(Integer id);

    Client createClient(Client client);

    Client updateClient(Integer id, Client client);

}
