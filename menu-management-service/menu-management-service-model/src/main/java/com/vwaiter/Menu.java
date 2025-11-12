package com.vwaiter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="menus")
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuId;
    public String name;
    @NotNull
    private Long b2bCustomerId;
    @OneToMany(cascade = CascadeType.MERGE)
    public List<Dish> dishes;

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }
}
