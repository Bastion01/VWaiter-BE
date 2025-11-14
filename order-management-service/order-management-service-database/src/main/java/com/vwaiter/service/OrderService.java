package com.vwaiter.service;

import com.vwaiter.Order;
import com.vwaiter.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
