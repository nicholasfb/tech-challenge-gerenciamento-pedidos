package com.fiap.tech.tech_order.order.adapter;

import com.fiap.tech.tech_order.domain.order.Order;
import com.fiap.tech.tech_order.domain.order.enums.Status;
import com.fiap.tech.tech_order.order.dto.OrderDTO;
import com.fiap.tech.tech_order.order.dto.OrderMessageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(imports = {Status.class})
public interface OrderAdapter {

    OrderAdapter INSTANCE = Mappers.getMapper(OrderAdapter.class);

    OrderDTO fromDomain(Order domain);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", defaultExpression = "java(Status.REQUESTED)")
    Order toDomain(OrderDTO dto);

    OrderMessageDTO toMessage(Order domain);

}