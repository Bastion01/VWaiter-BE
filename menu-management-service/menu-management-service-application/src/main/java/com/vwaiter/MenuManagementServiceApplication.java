package com.vwaiter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vwaiter.common.Currency;
import com.vwaiter.service.DishService;
import com.vwaiter.service.MenuService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:database.properties")
})
public class MenuManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuManagementServiceApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public ApplicationRunner dataLoader(DishService dishService, MenuService menuService) {
		return args -> {
			dishService.save(new Dish(null, "Borsch", 300, "Svyokla, voda i slyozi", 10, Currency.BYN, 4.99F, 1, 1));
			dishService.save(new Dish(null, "Pureshka s kotletkoy", 350, "Pureshka, kotletka", 15, Currency.BYN, 4.85F, 2, 2));
			dishService.save(new Dish(null, "Makaroni s sirom", 300, "Makaroni, sir", 12, Currency.BYN, 4.8F, 3, 3));
			dishService.save(new Dish(null, "Zapekanka", 250, "Tvorog, muka i vremya", 20, Currency.BYN, 4.999F, 2, 4));
			dishService.save(new Dish(null, "Bludo ot shefa", 1000, "Sekret", 50, Currency.BYN, 5F, 55, 5));
			menuService.save(new Menu(null, "Default", 1L, dishService.findAll()));
		};
	}
}
