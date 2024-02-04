package com.example.cron;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FetchingAlertsInfoCron {


    @Scheduled( fixedDelayString = "${alert.info.cron.fixed.delay}" ,
                initialDelayString = "${alert.info.cron.initial.delay}")
    public void prcessIncomingAlerts(){

    }

}
