package com.marge.curso.springboot.webapp.springboot_web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootWebApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void evidente() {
		assertThat("cadena").isEqualTo("cadena");
	}
}
