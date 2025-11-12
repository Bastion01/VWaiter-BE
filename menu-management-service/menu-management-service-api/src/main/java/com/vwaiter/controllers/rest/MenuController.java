package com.vwaiter.controllers.rest;

import com.vwaiter.Menu;
import com.vwaiter.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> getMenus() {
        List<Menu> menus = menuService.findAll();
        return ResponseEntity.ok(menus);
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> getMenu(@PathVariable Long id) {
        Menu menu = menuService.findById(id);
        return ResponseEntity.ok(menu);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        menuService.save(menu);
        return new ResponseEntity<>(menu, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public HttpStatus deleteMenu(@PathVariable Long id) {
        menuService.delete(id);
        return HttpStatus.NO_CONTENT;
    }
}
