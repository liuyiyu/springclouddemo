package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
@ExtendWith(MockitoExtension.class)
public class HelloControllerMockTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testGetCount() throws Exception {
        // Expected row count
        int expectedCount = 100;
        
        // Mock the static Utilities.getCount method
        try (MockedStatic<Utilities> utilities = Mockito.mockStatic(Utilities.class)) {
            utilities.when(Utilities::getCount).thenReturn(expectedCount);
            
            // Test the controller endpoint
            mockMvc.perform(get("/getcount"))
                   .andExpect(status().isOk())
                   .andExpect(content().string(String.valueOf(expectedCount)));
        }
    }
}