package com.hrms.userservice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.userservice.domain.EmpAttendance;
import com.hrms.userservice.repository.EmpAttendanceRepository;

@Service
public class EmpAttendanceServiceImpl implements EmpAttendanceService{

    @Autowired
    EmpAttendanceRepository empAttendanceRepository;
    
    @Override
    public EmpAttendance empAttendanceForLogIn(String empCode, String dateTime) {
        String[] parts = dateTime.split(" ");
        
        // find empAttendance by date and empCode
        EmpAttendance empAtt = empAttendanceRepository.findByEmpCodeAndAttendanceDate(empCode, parts[0]);
        if(empAtt == null){
            // create empAtt and add first log in time
            empAtt = new EmpAttendance();
            empAtt.setEmpCode(empCode);
            empAtt.setAttendanceDate(parts[0]);
            empAtt.setInTime(parts[1]);
            // save empAtt
            empAttendanceRepository.save(empAtt);
        }
        
        return empAtt;
    }

    @Override
    public EmpAttendance empAttendanceForLogOut(String empCode, String dateTime) {
        String[] parts = dateTime.split(" ");

        // find empAttendance by date and empCode
        EmpAttendance empAtt = empAttendanceRepository.findByEmpCodeAndAttendanceDate(empCode, parts[0]);
        if(empAtt != null){
            // update lastest log out time
            empAtt.setOutTime(parts[1]);
            //  calculate logout time - login time
            String att = calculateAttendence(empAtt.getInTime(), parts[1]);
            // set attendance 
            empAtt.setAttendance(att);
            // save empAtt
            empAttendanceRepository.save(empAtt);
        }

        return empAtt;
    }

    private String calculateAttendence(String inTime, String outTime){
        Date outDate = stringToDate(outTime, "HH:mm:ss");
        Date inDate = stringToDate(inTime, "HH:mm:ss");
        Long workHours = (outDate.getTime()-inDate.getTime())/1000/3600;
        String attendence = "";
        if(workHours>9){
            attendence = "Present";
        }else if(workHours>=4){
            attendence = "Half";
        }else{
            attendence = "Absent";
        }
        return attendence;
    }

    private Date stringToDate(String time, String pattern){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date=null;
        try{
            date = format.parse(time);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return date;
    }

    private String dateTimeToString(LocalDateTime ldt, String pattern){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return dtf.format(ldt);
    }
   
    
}
