package com.fiap.tech.tech_order.domain.order;

import com.fiap.tech.tech_order.domain.order.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Order {

    private Long id;

    private Long clientId;

    private List<OrderItem> items;

    private LocalDateTime orderDate;

    private LocalDateTime deliveryDate;

    private String note;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Status status;

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class OrderItem {

        private Long id;

        private Long productId;

        private Integer quantity;

        private Double unitPrice;

    }

}

