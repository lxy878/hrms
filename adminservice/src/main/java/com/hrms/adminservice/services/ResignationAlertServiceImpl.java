package com.hrms.adminservice.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.adminservice.component.DateComponent;
import com.hrms.adminservice.domain.ResignationAlert;
import com.hrms.adminservice.repository.ResignationAlertRepository;

@Service
public class ResignationAlertServiceImpl implements ResignationAlertService{
    @Autowired
    ResignationAlertRepository resignationAlertRepository;

    @Autowired
    DateComponent dateComponent;

    @Autowired
    UserService userService;
    
    @Override
    public ResignationAlert create(ResignationAlert resignationAlert) {
        
        return resignationAlertRepository.save(resignationAlert);
    }

    @Override
    public List<ResignationAlert> findAll() {
        return resignationAlertRepository.findAll();
    }

    @Override
    public Map<Long, String> deactivateAccounts() {
        List<ResignationAlert> resignationAlerts = findAll();
        String currentDate = dateComponent.dateTimeToString(LocalDateTime.now(), "yyyy-MM-dd");
        long cur = dateComponent.stringToDate(currentDate, "yyyy-MM-dd").getTime();
        Map<Long, String> deactivateAccounts = new HashMap<>();
        for(ResignationAlert r : resignationAlerts){
            long lwd = dateComponent.stringToDate(r.getLastWorkingDate(), "yyyy-MM-dd").getTime();
            int days = dateComponent.compareDates(cur, lwd);
            if(days<=0){
                userService.deactivateById(r.getuId());
                deactivateAccounts.put(r.getuId(), "Deactivated");
                resignationAlertRepository.deleteById(r.getId());
            }
        }
        return deactivateAccounts;
    }
}
