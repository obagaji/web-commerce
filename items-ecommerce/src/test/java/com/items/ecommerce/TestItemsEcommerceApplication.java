package com.items.ecommerce;

import org.springframework.boot.SpringApplication;

public class TestItemsEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ItemsEcommerceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
