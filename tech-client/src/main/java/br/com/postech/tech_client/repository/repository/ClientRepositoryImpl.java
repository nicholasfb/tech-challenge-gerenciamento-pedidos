package br.com.postech.tech_client.repository.repository;

import br.com.postech.tech_client.core.exception.NotFoundException;
import br.com.postech.tech_client.core.repository.ClientRepository;
import br.com.postech.tech_client.domain.client.Client;
import br.com.postech.tech_client.repository.adapter.ClientAdapter;
import br.com.postech.tech_client.repository.jpa.ClientJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientJpaRepository clientJpaRepository;

    private final ClientAdapter clientAdapter = ClientAdapter.INSTANCE;

    @Override
    public Set<Client> findAll() {
        return clientJpaRepository.findAll().stream().map(clientAdapter::fromEntity).collect(
                Collectors.toSet());
    }

    @Override
    public Optional<Client> findById(final Integer id) {
        return Optional.ofNullable(
                clientAdapter.fromEntity(
                        clientJpaRepository.findById(id).orElse(null)
                )
        );
    }

    @Override
    public Client create(final Client client) {
        return clientAdapter.fromEntity(
                clientJpaRepository.save(
                        clientAdapter.toEntity(
                                client
                        )
                )
        );
    }

    @Override
    public Client update(final Client client) {
        return clientAdapter.fromEntity(
                clientJpaRepository.save(
                        clientAdapter.update(
                                clientJpaRepository.findById(client.getId()).orElseThrow(
                                        () -> new NotFoundException("Cliente não encontrado")),
                                client
                        )
                )
        );
    }

}
