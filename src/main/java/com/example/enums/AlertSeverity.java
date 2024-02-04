package com.example.enums;

public enum AlertSeverity {
    CRITICAL("CRITICAL") , HIGH("HIGH") , MEDIUM("MEDIUM") , CASUAL("CASUAL");
    private String name ;
    AlertSeverity( String name ){
        this.name = name ;
    }
}
