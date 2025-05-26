package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilitiesTest {

    @Test
    public void testFileVersionInitialValue() {
        // Verify the default value of fileversion is 0
        assertEquals(0, Utilities.fileversion, "fileversion should be initialized to 0");
    }
}