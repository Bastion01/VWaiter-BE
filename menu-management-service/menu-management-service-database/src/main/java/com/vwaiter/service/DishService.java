package com.vwaiter.service;

import com.vwaiter.Dish;
import com.vwaiter.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;

    public Dish findById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public List<Dish> findAllByIds(Long[] ids) {
        return dishRepository.findAllById(Arrays.asList(ids));
    }

    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    public void delete(Long id) {
        dishRepository.deleteById(id);
    }
}
