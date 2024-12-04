package com.fiap.tech.tech_order.core.repository;

import com.fiap.tech.tech_order.domain.order.Order;

import java.util.Optional;
import java.util.Set;

public interface OrderRepository {

    Order save(Order order);

    Order update(Order order);

    Optional<Order> findById(Long id);

    Set<Order> findAll();

}
