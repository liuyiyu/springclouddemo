package com.azure.storage.blob;

import java.io.File;
import java.io.FileWriter;

/**
 * Mock implementation of BlobClient for testing
 */
public class BlobClient {
    public void downloadToFile(String fileName) {
        try {
            // Create a test file with mock content
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            
            if (fileName.contains("controlfile")) {
                // Mock content for control file
                writer.write("5");
            } else if (fileName.contains("data")) {
                // Mock content for data file
                writer.write("1,2023-01-01,101,REGULAR,2023-01-15\n");
                writer.write("2,2023-02-02,102,PREMIUM,2023-02-15\n");
            }
            
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}