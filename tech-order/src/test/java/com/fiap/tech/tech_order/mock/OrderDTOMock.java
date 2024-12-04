package com.fiap.tech.tech_order.mock;

import com.fiap.tech.tech_order.domain.order.enums.Status;
import com.fiap.tech.tech_order.order.dto.OrderDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDTOMock {

    public static OrderDTO create() {
        final List<OrderDTO.OrderItemDTO> items = new ArrayList<>();

        items.add(OrderDTO.OrderItemDTO.builder()
                          .productId(1L)
                          .quantity(10)
                          .unitPrice(1.5)
                          .build()
        );

        return OrderDTO.builder()
                .clientId(1L)
                .orderDate(LocalDateTime.now())
                .deliveryDate(LocalDateTime.now().plusDays(5))
                .note("Sample order note")
                .status(Status.REQUESTED)
                .items(items)
                .build();
    }

}
