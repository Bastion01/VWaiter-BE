package com.vwaiter.controllers.rest;

import com.vwaiter.OrderPayment;
import com.vwaiter.controllers.rest.mappers.OrderPaymentMapper;
import com.vwaiter.dto.OrderPaymentDto;
import com.vwaiter.processor.OrderPaymentProcessor;
import com.vwaiter.service.OrderPaymentService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orderPayments")
@RequiredArgsConstructor
public class OrderPaymentController {
    private final OrderPaymentService orderPaymentService;
    private final OrderPaymentProcessor orderPaymentProcessor;
    private final OrderPaymentMapper orderPaymentMapper = Mappers.getMapper(OrderPaymentMapper.class);

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderPayment> findById(@PathVariable Long id) {
        OrderPayment orderPayment = orderPaymentService.findById(id);
        return ResponseEntity.ok(orderPayment);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderPayment>> findAll() {
        List<OrderPayment> orderPayments = orderPaymentService.findAll();
        return ResponseEntity.ok(orderPayments);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderPayment> add(@RequestBody OrderPayment orderPayment) {
        orderPaymentService.save(orderPayment);
        return new ResponseEntity<>(orderPayment, HttpStatus.CREATED);
    }

    @PostMapping(path = "/automatic", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus addAndProcess(@RequestBody OrderPayment orderPayment) {
        orderPaymentService.save(orderPayment);
        orderPaymentProcessor.process(orderPayment);
        return HttpStatus.CREATED;
    }

    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderPayment> update(@PathVariable Long id, @RequestBody OrderPaymentDto orderPaymentDto) {
        OrderPayment orderPayment = orderPaymentService.findById(id);
        if (orderPayment != null) {
            orderPaymentMapper.updateOrderFromDto(orderPaymentDto, orderPayment);
            orderPaymentService.save(orderPayment);
        }
        return new ResponseEntity<>(orderPayment, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        orderPaymentService.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }

}
