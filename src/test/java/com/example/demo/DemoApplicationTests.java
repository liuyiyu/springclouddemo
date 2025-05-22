package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		// Verify the application context loads successfully
		assertNotNull(applicationContext, "Application context should not be null");
		
		// Check that our controller beans are available
		assertTrue(applicationContext.containsBean("helloController"), 
			"Application should contain HelloController bean");
	}

}
