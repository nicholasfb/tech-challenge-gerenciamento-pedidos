package br.com.postech.tech_gerenciamento_pedido.repository.adapter;

import br.com.postech.tech_gerenciamento_pedido.domain.client.Client;
import br.com.postech.tech_gerenciamento_pedido.repository.model.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientAdapter {

    ClientAdapter INSTANCE = Mappers.getMapper(ClientAdapter.class);

    ClientEntity toEntity(Client domain);

    Client fromEntity(ClientEntity entity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ClientEntity update(@MappingTarget ClientEntity persistedClient, Client updatedClient);

}
