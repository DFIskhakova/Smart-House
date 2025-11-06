package com.example.smart_house.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException (String s) {
        super(s);
    }
}
