package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UtilitiesTests {

    private static final String JDBC_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "password";

    @BeforeEach
    void setUp() {
        try {
            // Set up test database
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            
            // Drop and recreate the CUST table
            statement.execute("DROP TABLE IF EXISTS CUST");
            statement.execute("CREATE TABLE CUST(ID INT PRIMARY KEY, CREATEDATE DATE, CUSTID INT, CUSTTYPE VARCHAR(255), UPDATEDATE DATE)");
            
            // Insert test data
            statement.execute("INSERT INTO CUST VALUES(1, '2023-01-01', 101, 'REGULAR', '2023-01-15')");
            statement.execute("INSERT INTO CUST VALUES(2, '2023-02-02', 102, 'PREMIUM', '2023-02-15')");
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to set up test database: " + e.getMessage());
        }
    }

    @Test
    void testGetCount() {
        // Act
        int count = Utilities.getCount();
        
        // Assert
        assertEquals(2, count, "Should return 2 records from the test database");
    }

    @Test
    void testFileVersion() {
        // Test the static field initialization
        assertEquals(0, Utilities.fileversion, "Initial fileversion should be 0");
        
        // Update the field and verify
        Utilities.fileversion = 5;
        assertEquals(5, Utilities.fileversion, "Fileversion should be updated to 5");
    }
    
    @Test
    void testConnectionStrings() {
        // Verify connection strings are not null or empty
        assertNotNull(Utilities.connectStrPublic, "Public connection string should not be null");
        assertFalse(Utilities.connectStrPublic.isEmpty(), "Public connection string should not be empty");
        
        assertNotNull(Utilities.connectStrVNET, "VNET connection string should not be null");
        assertFalse(Utilities.connectStrVNET.isEmpty(), "VNET connection string should not be empty");
        
        assertEquals(Utilities.connectStrVNET, Utilities.connectStrA, "Default connection string should be VNET");
    }
    
    @Test
    void testDatabaseConnection() {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            assertNotNull(connection, "Database connection should be established");
            assertFalse(connection.isClosed(), "Connection should be open");
            
            connection.close();
            assertTrue(connection.isClosed(), "Connection should be closed");
        } catch (Exception e) {
            fail("Database connection failed: " + e.getMessage());
        }
    }
}