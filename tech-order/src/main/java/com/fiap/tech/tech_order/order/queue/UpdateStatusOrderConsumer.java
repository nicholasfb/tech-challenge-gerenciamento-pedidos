package com.fiap.tech.tech_order.order.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.tech.tech_order.core.business.OrderBusiness;
import com.fiap.tech.tech_order.core.queue.ProductQueueProducer;
import com.fiap.tech.tech_order.domain.order.Order;
import com.fiap.tech.tech_order.domain.order.enums.Status;
import com.fiap.tech.tech_order.order.dto.OrderStatusUpdateDTO;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateStatusOrderConsumer {

    private final OrderBusiness orderBusiness;

    private final ObjectMapper objectMapper;

    private final ProductQueueProducer productQueueProducer;

    @SqsListener("${queue.order.update.status.name}")
    public void updateStatus(String dto) {
        try {
            OrderStatusUpdateDTO orderUpdate = objectMapper.readValue(
                    dto, OrderStatusUpdateDTO.class);

            Order order = orderBusiness.getOrder(orderUpdate.getId());

            order.setStatus(Status.valueOf(orderUpdate.getStatus()));

            orderBusiness.putOrder(orderUpdate.getId(), order, false);

            if (orderUpdate.getStatus().equals(Status.CANCELLED.name())) {
                productQueueProducer.publish(order, true);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
