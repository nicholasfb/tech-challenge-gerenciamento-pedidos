package br.com.postech.tech_client.core.service;

import br.com.postech.tech_client.client.adapter.ClientAdapter;
import br.com.postech.tech_client.client.business.ClientBusinessImpl;
import br.com.postech.tech_client.core.exception.NotFoundException;
import br.com.postech.tech_client.core.exception.UnprocessableEntityException;
import br.com.postech.tech_client.core.repository.ClientRepository;
import br.com.postech.tech_client.domain.client.Client;
import br.com.postech.tech_client.mock.ClientMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClientBusinessTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientAdapter clientAdapter;

    @InjectMocks
    private ClientBusinessImpl clientBusiness;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getClients_sucesso() {
        Client clientEntity = ClientMock.mock();
        when(clientRepository.findAll()).thenReturn(Set.of(clientEntity));

        Set<Client> clients = clientBusiness.getClients();

        verify(clientRepository, times(1)).findAll();
        Assertions.assertNotNull(clients);
        Assertions.assertEquals(1, clients.size());
    }

    @Test
    void getClients_clienteNaoEncontrado() {
        when(clientRepository.findAll()).thenReturn(Set.of());

        assertThrows(NotFoundException.class, () -> clientBusiness.getClients());

        verify(clientRepository, times(1)).findAll();
    }

    @Test
    void buscarClientePorId_clienteNaoEncontrado() {
        Integer id = 1;
        when(clientRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> clientBusiness.getClient(id));

        verify(clientRepository, times(1)).findById(id);
    }

    @Test
    void create_Client_sucesso() {
        Client client = ClientMock.mock();
        when(clientRepository.create(client)).thenReturn(client);

        Assertions.assertDoesNotThrow(() ->
                                              clientBusiness.createClient(client)
        );

        verify(clientRepository, times(1)).create(client);
    }

    @Test
    void updateClient_sucesso() {
        Integer id = 1;
        Client client = ClientMock.mock();
        Client clientAtualizado = ClientMock.mock2();
        when(clientRepository.findById(id)).thenReturn(Optional.of(client));

        Assertions.assertDoesNotThrow(() ->
                                              clientBusiness.updateClient(id, clientAtualizado)
        );

        verify(clientRepository, times(1)).findById(id);
        verify(clientRepository, times(1)).update(any(Client.class));
    }

    @Test
    void updateClientNaoEncontrado() {
        Integer id = 1;
        Client clientAtualizado = ClientMock.mock2();

        when(clientRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(
                UnprocessableEntityException.class, () -> clientBusiness.updateClient(
                        id,
                        clientAtualizado
                )
        );

        verify(clientRepository, times(1)).findById(id);
        verify(clientRepository, times(0)).update(any(Client.class));
    }

}
