package com.vwaiter.controller.rest;

import com.vwaiter.Order;
import com.vwaiter.controller.rest.mappers.OrderMapper;
import com.vwaiter.dto.OrderDto;
import com.vwaiter.orchestration.OrderSagaOrchestrator;
import com.vwaiter.service.OrderService;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderSagaOrchestrator orderSagaOrchestrator;
    private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        orderService.save(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PostMapping(value = "/orchestrator", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> processOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderSagaOrchestrator.process(order)); //TODO async with message broker RabbitMQ
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        Order order = orderService.findById(id);
        if (order != null) {
            orderMapper.updateOrderFromDto(orderDto, order);
            orderService.save(order);
        }
        return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deleteOrder(@PathVariable Long id) {
        Order order = orderService.findById(id);
        orderService.delete(order);
        return HttpStatus.NO_CONTENT;
    }
}
