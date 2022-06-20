package com.axonactive.coffeeshopmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class CoffeeshopmanagementApplicationTests {

	@Test
	void contextLoads() {
		String encrtypedPassWord = new BCryptPasswordEncoder().encode("cashier");
		System.out.println(encrtypedPassWord);
	}

}
