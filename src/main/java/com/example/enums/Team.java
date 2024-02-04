package com.example.enums;

public enum Team {

    DEV("DEV") , TECHOPS("TECHOPS") , DEVOPS("DEVOPS") ;
    private String name ;

    Team( String name )
    {
        this.name = name ;
    }
}
