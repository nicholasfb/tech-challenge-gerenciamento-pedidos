package br.com.postech.tech_client.repository.jpa;

import br.com.postech.tech_client.repository.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientEntity, Integer> {

}
