package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		// Verify that the application context loads successfully
		assertNotNull(applicationContext, "Application context should not be null");
		
		// Verify the HelloController bean is created
		assertNotNull(applicationContext.getBean(HelloController.class), "HelloController should be available");
	}

	@Test
	void testApplicationStartup() {
		// Verify we can create the main application class
		DemoApplication application = new DemoApplication();
		assertNotNull(application, "DemoApplication instance should be created successfully");
	}
}
