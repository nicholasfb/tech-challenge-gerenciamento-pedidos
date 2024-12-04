package br.com.postech.tech_client.client.business;

import br.com.postech.tech_client.core.business.ClientBusiness;
import br.com.postech.tech_client.core.exception.NotFoundException;
import br.com.postech.tech_client.core.repository.ClientRepository;
import br.com.postech.tech_client.domain.client.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientBusinessImpl implements ClientBusiness {

    private final ClientRepository clientRepository;

    @Override
    public Set<Client> getClients() {
        Set<Client> clients = clientRepository.findAll();

        if (clients.isEmpty()) {
            throw new NotFoundException("Nenhum cliente encontrado.");
        }

        return clients;
    }

    @Override
    public Client getClient(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado."));
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.create(client);
    }

    @Override
    public Client updateClient(Integer id, Client client) {
        client.setId(id);

        return clientRepository.update(client);
    }

}
