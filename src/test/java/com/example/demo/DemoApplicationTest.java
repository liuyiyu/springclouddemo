package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class DemoApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private HelloController helloController;

    @Test
    public void contextLoads() {
        // Verify the context loads successfully
        assertNotNull(applicationContext);
    }
    
    @Test
    public void controllerLoads() {
        // Verify the HelloController is loaded
        assertNotNull(helloController);
    }
    
    @Test
    public void applicationCanBeCreated() {
        // Verify we can create the application
        DemoApplication app = new DemoApplication();
        assertNotNull(app);
    }
}