package br.com.postech.tech_gerenciamento_pedido.domain.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    private Integer id;

    private String name;

    private String document;

    private String email;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
