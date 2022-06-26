package com.hrms.userservice.component;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DataComponent {
    
    public String dateTimeToString(LocalDateTime ldt, String pattern){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return dtf.format(ldt);
    }
    
    public Date stringToDate(String time, String pattern){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date=null;
        try{
            date = format.parse(time);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return date;
    }
}
