package com.ezequiel.LaptopApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LaptopAppApplicationTests {

	@Test
	void contextLoads() {
		System.getenv().forEach(
				(key, value) -> System.out.println(key + "=" +value)
		);
	}

}
