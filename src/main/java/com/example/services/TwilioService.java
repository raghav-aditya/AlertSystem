package com.example.services;

import org.springframework.stereotype.Service;

@Service
public interface TwilioService {
    public void sendMessageNotification( String to , String message );
    public void sendWhatsAppNotification(  String to , String message );
    public void sendEmailNotification(  String to , String message );
    public void sendCallNotification( String to , String message );
}
