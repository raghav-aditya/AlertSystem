package com.example.utility;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.constant.Constants.TwilioMessageTemplate.CALL_TEMPLATE;

public class AppUtils {


    public static String getUniqueId(){
        UUID ackNumber = UUID.randomUUID() ;
        return ackNumber.toString();
    }

    public static String getCallString( String team , String severity , String msg ){

        String call_msg = CALL_TEMPLATE ;
        String[] values = {team, severity , msg};
        return replaceVariables( call_msg , values );
    }

    public static String replaceVariables(String template, String... values) {
        if (values.length == 0) {
            return template;
        }
        StringBuilder result = new StringBuilder(template);
        Pattern pattern = Pattern.compile("\\?");
        Matcher matcher = pattern.matcher(result);
        int i = 0;
        while (matcher.find() && i < values.length) {
            result.replace(matcher.start(), matcher.end(), values[i]);
            i++;
        }
        return result.toString();
    }

}

