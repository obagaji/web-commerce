package com.customer;

import org.springframework.boot.SpringApplication;

public class TestComCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.from(ComCustomerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
