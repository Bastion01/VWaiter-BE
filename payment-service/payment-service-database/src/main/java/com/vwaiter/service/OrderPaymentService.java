package com.vwaiter.service;

import com.vwaiter.OrderPayment;
import com.vwaiter.repository.OrderPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderPaymentService {
    private final OrderPaymentRepository orderPaymentRepository;

    public OrderPayment findById(Long id) {
        return orderPaymentRepository.findById(id).orElse(null);
    }

    public List<OrderPayment> findAll() {
        return orderPaymentRepository.findAll();
    }

    public void save(OrderPayment orderPayment) {
        orderPaymentRepository.save(orderPayment);
    }

    public void deleteById(Long id) {
        orderPaymentRepository.deleteById(id);
    }
}
