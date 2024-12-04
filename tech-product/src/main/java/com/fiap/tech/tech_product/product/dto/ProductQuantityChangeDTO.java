package com.fiap.tech.tech_product.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductQuantityChangeDTO {

    private Long productId;

    private Integer quantity;

    private Boolean cancelled;

}
