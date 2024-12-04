package br.com.postech.tech_client.client.controller;

import br.com.postech.tech_client.client.adapter.ClientAdapter;
import br.com.postech.tech_client.client.dto.ClientDTO;
import br.com.postech.tech_client.core.business.ClientBusiness;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ClientController {

    private final ClientBusiness clientBusiness;

    private final ClientAdapter clientAdapter = ClientAdapter.INSTANCE;

    @GetMapping("/api/client")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDTO> getClients() {
        return clientBusiness.getClients().stream().map(clientAdapter::fromDomain).toList();
    }

    @GetMapping("/api/client/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDTO getClient(@PathVariable Integer id) {
        return clientAdapter.fromDomain(clientBusiness.getClient(id));
    }

    @PostMapping("/api/client")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO createClient(@Valid @RequestBody ClientDTO clientDTO) {
        return clientAdapter.fromDomain(
                clientBusiness.createClient(clientAdapter.toDomain(clientDTO)));
    }

    @PutMapping("/api/client/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClientDTO updateClient(@PathVariable Integer id, @RequestBody
    ClientDTO clientDTO) {
        return clientAdapter.fromDomain(
                clientBusiness.updateClient(id, clientAdapter.toDomain(clientDTO)));
    }

}
