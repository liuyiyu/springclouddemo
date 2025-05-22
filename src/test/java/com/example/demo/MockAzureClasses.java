package com.example.demo;

import java.io.File;

/**
 * Mock classes for Azure Blob Storage to be used only during testing
 */
public class MockAzureClasses {
    
    // Mock classes for Azure Blob Storage
    public static class BlobServiceClientBuilder {
        public BlobServiceClientBuilder connectionString(String connectionString) {
            return this;
        }
        
        public BlobServiceClient buildClient() {
            return new BlobServiceClient();
        }
    }
    
    public static class BlobServiceClient {
        public BlobContainerClient getBlobContainerClient(String containerName) {
            return new BlobContainerClient();
        }
    }
    
    public static class BlobContainerClient {
        public BlobClient getBlobClient(String blobName) {
            return new BlobClient();
        }
    }
    
    public static class BlobClient {
        public void downloadToFile(String fileName) {
            // Mock implementation that creates an empty file
            try {
                File file = new File(fileName);
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}