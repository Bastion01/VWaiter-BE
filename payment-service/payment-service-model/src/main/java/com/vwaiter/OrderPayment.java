package com.vwaiter;

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
@Table(name = "order_payments")
@DynamicUpdate
public class OrderPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderPaymentId;
    private Long orderId;
    private String b2bCustomerName;
    private String waiterName;
    private int tableId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderPaymentItem> orderPaymentItems;
    private float totalPrice;
    private PaymentInstrument paidBy;
    private Date paidWhen;
}
