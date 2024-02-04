package com.example.utility;

import java.util.UUID;

public class AppUtils {


    public static String getUniqueId(){
        UUID ackNumber = UUID.randomUUID() ;
        return ackNumber.toString();
    }

}
