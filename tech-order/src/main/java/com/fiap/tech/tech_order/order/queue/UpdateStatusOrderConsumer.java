package com.fiap.tech.tech_order.order.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.tech.tech_order.core.business.OrderBusiness;
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

    @SqsListener("${queue.order.update.status.name}")
    public void updateStatus(String dto) {
        try {
            OrderStatusUpdateDTO orderUpdate = objectMapper.readValue(
                    dto, OrderStatusUpdateDTO.class);

            Order order = orderBusiness.getOrder(orderUpdate.getId());

            order.setStatus(Status.valueOf(orderUpdate.getStatus()));

            orderBusiness.putOrder(orderUpdate.getId(), order, false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
