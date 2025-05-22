package com.azure.storage.blob;

/**
 * Mock implementation of BlobServiceClientBuilder for testing
 */
public class BlobServiceClientBuilder {
    public BlobServiceClientBuilder connectionString(String connectionString) {
        return this;
    }
    
    public BlobServiceClient buildClient() {
        return new BlobServiceClient();
    }
}