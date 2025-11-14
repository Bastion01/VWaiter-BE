package com.vwaiter;

import com.vwaiter.common.OrderStatus;
import com.vwaiter.common.PaymentInstrument;
import com.vwaiter.service.OrderService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:database.properties")
})
public class OrderManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementServiceApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(OrderService orderService) {
		return args -> {
			OrderItem orderItemOne = new OrderItem(null, 1L, 1);
			OrderItem orderItemTwo = new OrderItem(null, 2L, 2);
			OrderItem orderItemThree = new OrderItem(null, 4L, 3);
			OrderItem orderItemFour = new OrderItem(null, 5L, 1);
			OrderItem orderItemFive = new OrderItem(null, 3L, 5);

			orderService.save(new Order(
					null, 1L, new Date(), OrderStatus.IN_PROGRESS, 1L, 2, 3L,
                    List.of(orderItemOne), null, null)
			);

			orderService.save(new Order(
					null, 2L, new Date(), OrderStatus.CREATED, 1L, 3, 3L,
					Arrays.asList(orderItemTwo, orderItemThree, orderItemFour), null, null)
			);

			orderService.save(new Order(
					null, 3L, new Date(), OrderStatus.PAID, 1L, 2, 3L,
                    List.of(orderItemFive), PaymentInstrument.CASH, new Date())
			);
		};
	}
}
