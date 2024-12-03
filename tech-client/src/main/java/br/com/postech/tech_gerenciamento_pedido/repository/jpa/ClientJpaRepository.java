package br.com.postech.tech_gerenciamento_pedido.repository.jpa;

import br.com.postech.tech_gerenciamento_pedido.repository.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientEntity, Integer> {

}
