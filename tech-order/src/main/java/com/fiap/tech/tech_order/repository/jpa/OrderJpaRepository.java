package com.fiap.tech.tech_order.repository.jpa;

import com.fiap.tech.tech_order.repository.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {

}
