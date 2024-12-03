package br.com.postech.tech_gerenciamento_pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"br.com.postech.tech_gerenciamento_pedido.repository.jpa"})
public class TechGerenciamentoPedidoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechGerenciamentoPedidoApplication.class, args);
    }

}
