package com.azure.storage.blob;

/**
 * Mock implementation of BlobContainerClient for testing
 */
public class BlobContainerClient {
    public BlobClient getBlobClient(String blobName) {
        return new BlobClient();
    }
}