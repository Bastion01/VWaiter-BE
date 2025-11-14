package com.vwaiter;

import com.vwaiter.common.OrderStatus;
import com.vwaiter.common.PaymentInstrument;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@DynamicUpdate
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Long customerId;
    private Date createdWhen;
    private OrderStatus status;
    private Long b2bCustomerId;
    private int tableId;
    private Long waiterId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
    private PaymentInstrument paidBy;
    private Date paidWhen;

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }
}
