package com.vwaiter.controllers.rest;

import com.vwaiter.Dish;
import com.vwaiter.dto.DishDto;
import com.vwaiter.mappers.DishMapper;
import com.vwaiter.service.DishService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dishes")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;
    private final DishMapper dishMapper = Mappers.getMapper(DishMapper.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dish>> getDishes() {
        List<Dish> dishes = dishService.findAll();
        return ResponseEntity.ok(dishes);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
        dishService.save(dish);
        return new ResponseEntity<>(dish, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDish(@PathVariable Long id) {
        Dish dish = dishService.findById(id);
        return ResponseEntity.ok(dish);
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @RequestBody DishDto dishInput) {
        Dish dish = dishService.findById(id);
        if (dish != null) {
            dishMapper.updateDishFromDto(dishInput, dish);
            dishService.save(dish);
        }
        return new ResponseEntity<>(dish, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteDish(@PathVariable Long id) {
        dishService.delete(id);
        return HttpStatus.NO_CONTENT;
    }
}
