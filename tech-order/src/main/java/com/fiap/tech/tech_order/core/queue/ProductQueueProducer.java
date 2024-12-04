package com.fiap.tech.tech_order.core.queue;

import com.fiap.tech.tech_order.domain.order.Order;

public interface ProductQueueProducer {

    void publish(Order order, Boolean cancelled);

}
