package com.example.constant;

public interface Constants {

    public interface User {
        final String ADMIN = "ADMIN";
        final String EMPLOYEE = "EMPLOYEE" ;
    }

    public interface Logs {
        final String REQUEST_ID = "REQUEST_ID" ;
    }

    public interface CRON {
        final String ALERT_FETCH_CRON = "ALERT_FETCH_CRON";
    }

    public interface TwilioMessageTemplate{
        String CALL_TEMPLATE = "<Response><Say> IncidentOccured in ?team team of  ?severity severity , the incident is ?alertmessage </Say></Response>";
    }

}
