package com.fiap.tech.tech_logistic.repository.jpa;

import com.fiap.tech.tech_logistic.domain.delivery.status.Status;
import com.fiap.tech.tech_logistic.repository.model.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryJpaRepository extends JpaRepository<DeliveryEntity, Long> {

    List<DeliveryEntity> findByStatus(Status status);

    Optional<DeliveryEntity> findByOrderId(Long orderId);

}
