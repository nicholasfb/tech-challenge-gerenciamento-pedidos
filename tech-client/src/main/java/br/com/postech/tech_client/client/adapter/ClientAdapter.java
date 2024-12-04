package br.com.postech.tech_client.client.adapter;

import br.com.postech.tech_client.client.dto.ClientDTO;
import br.com.postech.tech_client.domain.client.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientAdapter {

    ClientAdapter INSTANCE = Mappers.getMapper(ClientAdapter.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    Client toDomain(ClientDTO dto);

    ClientDTO fromDomain(Client domain);

}
