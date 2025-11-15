package com.vwaiter.orchestration;

import com.vwaiter.Order;
import com.vwaiter.common.OrderStatus;
import com.vwaiter.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class OrderSagaOrchestrator {
    private OrderService orderService;

    @Transactional
    public Order process(final Order order) {
        order.setStatus(OrderStatus.CREATED);
        order.setCreatedWhen(new Date());
        orderService.save(order);
        try {
            /*
            1. send notification to waiters or directly to kitchen
            // AWAITING_CONFIRMATION
            2. waiting for free waiter to update/confirm or kitchen acknowledgement
            // IN_PROGRESS + send push to user
            3. waiting for kitchen readiness notification
            // COMPLETED + send push to user
            4. waiting for user "schet pozhaluista" notification
            // AWAITING_PAYMENT + send notification for waiter
            5. perform pre-check generation and special offers applying
            6. invoke payment service
            7. obtain payment + notification for user "vse ok? kak oficiant, eda i vashe?"
            // PAID
             */
        } catch (Exception e) {
            //handle error and rollback necessary steps
            log.error(e.getMessage(), e);
        }
        return order;
    }
}
