package com.example;

public enum RootNature {
    NOT_QUADRATIC("Not a quadratic equation"),
    REAL_ROOTS("Real roots"),
    IMAGINARY_ROOTS("Imaginary roots"),
    EQUAL_ROOTS("Equal roots");
    
    private final String description;
    
    RootNature(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return description;
    }
}