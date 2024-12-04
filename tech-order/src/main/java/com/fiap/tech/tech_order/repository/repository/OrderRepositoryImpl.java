package com.fiap.tech.tech_order.repository.repository;

import com.fiap.tech.tech_order.core.exception.NotFoundException;
import com.fiap.tech.tech_order.core.repository.OrderRepository;
import com.fiap.tech.tech_order.domain.order.Order;
import com.fiap.tech.tech_order.repository.adapter.OrderAdapter;
import com.fiap.tech.tech_order.repository.jpa.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    private final OrderAdapter orderAdapter = OrderAdapter.INSTANCE;

    @Override
    public Order save(final Order order) {
        return orderAdapter.fromEntity(
                orderJpaRepository.save(
                        orderAdapter.toEntity(
                                order
                        )
                )
        );
    }

    @Override
    public Order update(final Order order) {
        return orderAdapter.fromEntity(
                orderJpaRepository.save(
                        orderAdapter.update(
                                orderJpaRepository.findById(order.getId()).orElseThrow(
                                        () -> new NotFoundException("Pedido não encontrado")),
                                order
                        )
                )
        );
    }

    @Override
    public Optional<Order> findById(final Long id) {
        return Optional.ofNullable(
                orderAdapter.fromEntity(
                        orderJpaRepository.findById(id).orElse(null)
                )
        );
    }

    @Override
    public Set<Order> findAll() {
        return orderJpaRepository.findAll().stream()
                .map(orderAdapter::fromEntity)
                .collect(Collectors.toSet());
    }

}
