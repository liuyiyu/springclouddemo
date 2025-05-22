package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mockStatic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
class HelloControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testIndex() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    void testGetCount() throws Exception {
        // Use mockStatic to mock the static method call
        try (MockedStatic<Utilities> utilities = mockStatic(Utilities.class)) {
            // Configure the mock to return a specific value
            utilities.when(Utilities::getCount).thenReturn(42);
            
            // Test the endpoint
            mockMvc.perform(get("/getcount"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("42")));
        }
    }
}