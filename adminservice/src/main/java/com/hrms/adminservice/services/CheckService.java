package com.hrms.adminservice.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.adminservice.component.DateComponent;
import com.hrms.adminservice.domain.EmailAlert;
import com.hrms.adminservice.domain.Employee;
import com.hrms.adminservice.domain.LeaveDetail;
import com.hrms.adminservice.domain.User;
import com.hrms.adminservice.repository.EmailAlertRepository;



@Service
public class CheckService{
    
    @Autowired
    EmailService emailService;

    @Autowired
    EmailAlertRepository emailAlertRepository;

    @Autowired
    DateComponent dateComponent;

    @Autowired
    LeaveDetailService leaveDetailService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    UserService userService;

    public String leaveCheck(Long uId){
        
        String today = dateComponent.dateTimeToString(LocalDateTime.now(), "yyyy-MM-dd");
        EmailAlert alert = emailAlertRepository.findByUserIdAndCheckDate(uId, today);
        String message = "Email sent already.";
        if(alert == null){
            alert = new EmailAlert();
            alert.setUserId(uId);
            alert.setCheckDate(today);
            emailAlertRepository.save(alert);

            Employee emp = employeeService.findByEmailId(uId);

            List<LeaveDetail> leaves = leaveDetailService.findAllOrderByAppliedDate(emp.getEmpCode(), "pending");
            if(leaves.isEmpty()){
                return "no leave";
            }
            LeaveDetail eld = leaves.get(0);
            String date = eld.getAppliedDate().split(" ")[0];
            long ts = dateComponent.stringToDate(today, "yyyy-MM-dd").getTime();
            long as = dateComponent.stringToDate(date, "yyyy-MM-dd").getTime();
            int days = dateComponent.getDays(as, ts);
            if(days>=5){
                
                User user = userService.findById(uId);
                emailService.sendEmail(user.getEmail(), "Leave Approve Alert", "There are Leaves that need to approve");
                message = "Email is sent.";
            }
        }
        
        return message;
    }

}
