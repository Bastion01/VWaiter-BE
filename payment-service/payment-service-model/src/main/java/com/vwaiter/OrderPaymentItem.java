package com.vwaiter;

import com.vwaiter.common.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_payment_items")
@DynamicUpdate
public class OrderPaymentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderPaymentItemId;
    private String name;
    private int amount;
    private float price;
    private Currency currency;
}
