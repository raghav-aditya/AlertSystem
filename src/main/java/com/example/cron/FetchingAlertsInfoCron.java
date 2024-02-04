package com.example.cron;

import com.example.constant.Constants;
import com.example.cron.helper.impl.FetchingAlertsInfoCronHelperImpl;
import com.example.enums.AlertSeverity;
import com.example.enums.Team;
import com.example.utility.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class FetchingAlertsInfoCron {


    @Autowired
    private FetchingAlertsInfoCronHelperImpl fetchingAlertsInfoCronHelper ;


    @Scheduled( fixedDelayString = "${alert.info.cron.fixed.delay}" ,initialDelayString = "${alert.info.cron.initial.delay}")
    public void prcessIncomingAlerts(){
        Map<String, Object> metaData = initialiseMetaData();
        try {
                String requestId = AppUtils.getUniqueId();
                ThreadContext.put(Constants.Logs.REQUEST_ID, requestId);

                Long start = System.currentTimeMillis();
                log.info(" starting " + Constants.CRON.ALERT_FETCH_CRON + "....");

                fetchingAlertsInfoCronHelper.fetchAndProcessNewALerts(metaData);

        } catch ( Exception e ){
            log.error(" exception occured in {} : " , Constants.CRON.ALERT_FETCH_CRON , e );
        } finally {
            log.info("metaData of cron: {}" , metaData );
        }

    }

    private Map<String, Object> initialiseMetaData() {
        Map< String , Object > metaData = new HashMap<>();
        metaData.put(AlertSeverity.CASUAL.getName() , 0 );
        metaData.put(AlertSeverity.MEDIUM.getName()  , 0 );
        metaData.put(AlertSeverity.HIGH.getName()  , 0 );
        metaData.put(AlertSeverity.CRITICAL.getName()  , 0 );
        metaData.put(Team.DEV.getName()  , 0);
        metaData.put(Team.DEVOPS.getName()  , 0 );
        metaData.put(Team.TECHOPS.getName()  , 0 );
        return  metaData ;
    }

}
