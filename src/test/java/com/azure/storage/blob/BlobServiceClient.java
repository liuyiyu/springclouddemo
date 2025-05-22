package com.azure.storage.blob;

/**
 * Mock implementation of BlobServiceClient for testing
 */
public class BlobServiceClient {
    public BlobContainerClient getBlobContainerClient(String containerName) {
        return new BlobContainerClient();
    }
}