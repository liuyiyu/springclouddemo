package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UtilitiesDBTest {
    
    @Test
    public void testGetCountWithMockedDB() throws Exception {
        // Create mocks for database objects
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        ResultSet mockResultSet = mock(ResultSet.class);
        
        // Expected row count
        int expectedCount = 5;
        
        // Configure mock behaviors
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false); // Return true once, then false to exit the loop
        when(mockResultSet.getInt("count(*)")).thenReturn(expectedCount);
        
        // Use MockedStatic to mock the DriverManager.getConnection method
        try (MockedStatic<DriverManager> driverManagerMock = Mockito.mockStatic(DriverManager.class)) {
            driverManagerMock.when(() -> DriverManager.getConnection(anyString(), anyString(), anyString()))
                    .thenReturn(mockConnection);
            
            // Call the actual method we want to test
            int actualCount = Utilities.getCount();
            
            // Verify the result
            assertEquals(expectedCount, actualCount, "The row count should match the expected value");
        }
    }
}