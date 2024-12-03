package br.com.postech.tech_gerenciamento_pedido.mock;

import br.com.postech.tech_gerenciamento_pedido.domain.client.Client;

import java.time.LocalDateTime;

public class ClientMock {

    public static Client mock() {
        return new Client(
                1, "Filipe", "12345678909",
                "filipemagarotto1213@gmail.com", "11999176700", "Rua 1",
                "São Paulo", "SP", "11222333", LocalDateTime.now(), LocalDateTime.now()
        );
    }

    public static Client mock2() {
        return new Client(
                1, "Novo Nome", "98765432100",
                "novoemail@teste.com", "11999111111", "Rua Nova", "Rio de Janeiro", "RJ",
                "44555666", LocalDateTime.now(), LocalDateTime.now()
        );
    }

}
