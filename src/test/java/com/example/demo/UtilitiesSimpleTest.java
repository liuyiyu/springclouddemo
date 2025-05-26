package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Simple tests for the Utilities class
 * These tests validate the structure and constant values but don't test methods
 * that require external dependencies
 */
public class UtilitiesSimpleTest {

    @Test
    public void testFileVersionInitialValue() {
        // Verify the default value of fileversion is 0
        assertEquals(0, Utilities.fileversion, "fileversion should be initialized to 0");
    }

    @Test
    public void testConnectionStringFormat() {
        // Verify that the connection strings are properly formatted
        assertTrue(Utilities.connectStrPublic.contains("DefaultEndpointsProtocol=https"), 
            "Connection string should include protocol");
        
        assertTrue(Utilities.connectStrPublic.contains("AccountName="), 
            "Connection string should include account name");
            
        assertTrue(Utilities.connectStrPublic.contains("AccountKey="), 
            "Connection string should include account key");
            
        assertTrue(Utilities.connectStrPublic.contains("EndpointSuffix="), 
            "Connection string should include endpoint suffix");
    }

    @Test
    public void testConnectStrAssignment() {
        // Verify that connectStrA is assigned the value of connectStrVNET
        assertEquals(Utilities.connectStrVNET, Utilities.connectStrA, 
            "connectStrA should be assigned the value of connectStrVNET");
    }
}