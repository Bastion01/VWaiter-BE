package com.vwaiter;

import com.vwaiter.common.Currency;
import com.vwaiter.service.OrderPaymentService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Arrays;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:database.properties")
})
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(OrderPaymentService orderPaymentService) {
		return args -> {
			OrderPaymentItem orderPaymentItem1 = new OrderPaymentItem(null, "Borsch", 1, 12.00f, Currency.BYN);
			OrderPaymentItem orderPaymentItem2 = new OrderPaymentItem(null, "Pelmeni", 2, 35.00f, Currency.BYN);
			OrderPaymentItem orderPaymentItem3 = new OrderPaymentItem(null, "Kotletka", 1, 6.00f, Currency.BYN);

			orderPaymentService.save(new OrderPayment(
					null, 1L, "KFC", "Denis",
					1, Arrays.asList(orderPaymentItem1), 12.00f,
					null, null)
			);
			orderPaymentService.save(new OrderPayment(
					null, 2L, "Vasilki", "Denis",
					1, Arrays.asList(orderPaymentItem2, orderPaymentItem3), 41.00f,
					null, null)
			);
		};
	}
}
