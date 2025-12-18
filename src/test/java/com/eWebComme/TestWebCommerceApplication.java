package com.eWebComme;

import org.springframework.boot.SpringApplication;

public class TestWebCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.from(WebCommerceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
