package com.example.cron.helper.impl;


import com.example.enums.AlertSeverity;
import com.example.enums.Team;
import com.example.model.AlertDB;
import com.example.model.Employee;
import com.example.model.InstancesOccured;
import com.example.services.AlertDBRepository;
import com.example.services.EmployeeRepository;
import com.example.services.InstancesOccuedRepository;
import com.example.services.TwilioService;
import com.example.utility.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class FetchingAlertsInfoCronHelperImpl {

    @Autowired
    private AlertDBRepository alertDBRepository ;

    @Autowired
    private InstancesOccuedRepository instancesOccuedRepository ;

    @Autowired
    private EmployeeRepository employeeRepository ;

    @Autowired
    private TwilioService twilioService ;


    public void fetchAndProcessNewALerts(Map<String, Object> metaData){

        List< InstancesOccured > newInstances = instancesOccuedRepository.findByIsPickedFalse() ;

        for( InstancesOccured instance : newInstances ){
            AlertDB alert = alertDBRepository.findByAlertName(instance.getIncident());
            if(Objects.nonNull(alert)){
                updateMetaData( alert , metaData);
                processAlertNotifyEmployee(alert);
            }
        }


    }

    private void processAlertNotifyEmployee(AlertDB alert) {

        String severity = alert.getSeverity();
        AlertSeverity alertSeverity = AlertSeverity.getSeverityByName(severity);

        String onCallFromTeam = getOncallFromTeam(alert.getTeam());

        switch ( alertSeverity ){
            case CRITICAL ->{
                twilioService.sendCallNotification( onCallFromTeam , AppUtils.getCallString(alert.getTeam(), severity , alert.getAlertName()) );
            }
            case HIGH -> {
                twilioService.sendMessageNotification( onCallFromTeam ,  alert.getAlertName() );
            }
            case MEDIUM -> {
                twilioService.sendEmailNotification( onCallFromTeam , alert.getAlertName() );
            }
            case CASUAL -> {
                twilioService.sendWhatsAppNotification( onCallFromTeam , alert.getAlertName() );
            }
        }
    }

    private String getOncallFromTeam(String team) {
            List<Employee> employeeList = employeeRepository.findOnCallEmployeesByTeam(team);
            return employeeList.get(0).getPhoneNum();
    }

    private void updateMetaData(AlertDB alert, Map<String, Object> metaData) {

        // team based
        metaData.put( alert.getTeam() , (Long)metaData.get(alert.getTeam()) + 1L );

        // severity based
        metaData.put( alert.getSeverity() , (Long)metaData.get(alert.getSeverity()) + 1L );
    }
}
