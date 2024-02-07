package com.example.services.impl;

import com.example.services.TwilioService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class TwilioServiceImpl implements TwilioService {

    @Value("${SID}")
    private String SID;

    @Value("${TOKEN}")
    private String TOKEN ;


    @Override
    public void sendMessageNotification( String to , String message) {
        Twilio.init(SID, TOKEN);
        Message messageTool = Message.creator(
                        new com.twilio.type.PhoneNumber("+919636505634"),
                        new com.twilio.type.PhoneNumber("+18645280694"),
                        message)
                .create();

        log.info("Sending the Phone Message to Number: {} , ", to , messageTool.getSid());
    }

    @Override
    public void sendWhatsAppNotification(String to , String message) {
        Twilio.init(SID, TOKEN);
        Message whatsAppTool = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+919636505634"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                message)
                        .create();
        log.info("Sending the whatsApp Message to Number: {} , ", to , whatsAppTool.getSid());
    }

    @Override
    public void sendEmailNotification(String to , String message) {
     log.info("not implemented yet it needs login with different product of twilio now");
    }

    @Override
    public void sendCallNotification( String to , String message) {
        Twilio.init(SID, TOKEN);
        Call callTool = Call.creator(
                        new com.twilio.type.PhoneNumber("+919636505634"),
                        new com.twilio.type.PhoneNumber("+15017122661"),
                        new com.twilio.type.Twiml(message))
                .create();
        log.info("Sending outBound call notification to Phone Number: {} , ", to , callTool.getSid());
    }
}

