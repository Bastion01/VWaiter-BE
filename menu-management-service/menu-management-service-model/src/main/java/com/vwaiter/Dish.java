package com.vwaiter;

import com.vwaiter.common.Currency;
import com.vwaiter.crutches.OrderNumberGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="dishes")
@DynamicUpdate
public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dishId;
    public String name;
    public int weight;
    public String composition;
    public int price;
    public Currency currency;
    public float rating;
    @Column(name = "reviews_amount")
    public int reviewsAmount;
    @Column(name = "order_number")
    public int orderNumber = OrderNumberGenerator.getOrderNumberGenerator().getOrderNumber();

    @PrePersist
    protected void onCreate() {
        OrderNumberGenerator.incrementInMemoryCounter();
    }
}
