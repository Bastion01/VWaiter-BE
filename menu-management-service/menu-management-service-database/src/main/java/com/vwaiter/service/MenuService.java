package com.vwaiter.service;

import com.vwaiter.Menu;
import com.vwaiter.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public Menu findById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    public void delete(Long id) {
        menuRepository.deleteById(id);
    }
}
