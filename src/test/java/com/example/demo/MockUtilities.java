package com.example.demo;

/**
 * Mock Utilities class for testing purposes
 * This avoids the need for the actual Azure Blob Storage dependency in tests
 */
public class MockUtilities {
    
    public static final int MOCK_COUNT = 5;
    public static final int MOCK_FILE_VERSION = 42;
    
    /**
     * Mock implementation of getCount that returns a fixed value
     */
    public static int getCount() {
        return MOCK_COUNT;
    }
    
    /**
     * Mock implementation of getControlFileVersion that returns a fixed value
     */
    public static int getControlFileVersion() {
        return MOCK_FILE_VERSION;
    }
    
    /**
     * Mock implementation of downloadData that does nothing
     */
    public static void downloadData() {
        // Do nothing, just a mock implementation
    }
}