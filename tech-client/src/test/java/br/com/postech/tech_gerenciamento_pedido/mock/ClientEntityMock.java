package br.com.postech.tech_gerenciamento_pedido.mock;

import br.com.postech.tech_gerenciamento_pedido.repository.model.ClientEntity;

import java.time.LocalDateTime;

public class ClientEntityMock {

    public static ClientEntity mock() {
        return new ClientEntity(
                1, "Filipe", "12345678909",
                "filipemagarotto1213@gmail.com", "11999176700", "Rua 1",
                "São Paulo", "SP", "11222333", LocalDateTime.now(), LocalDateTime.now()
        );
    }

}
