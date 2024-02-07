package com.example.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum AlertSeverity {
    CRITICAL("CRITICAL") , HIGH("HIGH") , MEDIUM("MEDIUM") , CASUAL("CASUAL");
    private String name ;
    AlertSeverity( String name ){
        this.name = name ;
    }

    private static Map< String , AlertSeverity > map = new HashMap<>();

    static {
        for( AlertSeverity alertSeverity : Arrays.asList(values())){
            map.put(alertSeverity.getName() , alertSeverity);
        }
    }

    public String getName(){
        return this.name ;
    }
    public static AlertSeverity getSeverityByName(String alertSeverity){
        return map.get(alertSeverity==null? null : alertSeverity.toUpperCase());
    }
}
