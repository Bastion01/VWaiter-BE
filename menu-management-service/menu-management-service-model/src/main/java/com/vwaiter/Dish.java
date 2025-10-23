package com.vwaiter;

import com.vwaiter.common.Currency;
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
    private Long id;
    public String name;
    public int weight;
    public String composition;
    public int price;
    public Currency currency;
    public float rating;
    @Column(name = "reviews_amount")
    public int reviewsAmount;
}
