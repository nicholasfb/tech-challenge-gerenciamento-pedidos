package com.fiap.tech.tech_order.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StorageDTO {

    private Long productId;

    private Integer quantity;

    private Boolean cancelled;

}
