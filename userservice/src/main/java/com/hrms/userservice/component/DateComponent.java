package com.hrms.userservice.component;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateComponent {
    
    public String dateTimeToString(LocalDateTime ldt, String pattern){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return dtf.format(ldt);
    }
    
    public Date stringToDate(String time, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date=null;
        try{
            date = format.parse(time);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return date;
    }

    public int getDays(Long fromDate, Long toDate){
        long days = Math.abs(toDate-fromDate);
        return (int) TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS)+1;
    }

    public String incrementDay(String date, int numberOfDay){
        return LocalDate.parse(date).plusDays(numberOfDay).toString();
    }

    public String changeDateForm(String date, String oldForm, String newForm){
        SimpleDateFormat sdf = new SimpleDateFormat(oldForm);
        String newDate = "";
        try{
            Date d = sdf.parse(date);
            sdf.applyPattern(newForm);
            newDate = sdf.format(d);
        } catch(ParseException e){
            e.printStackTrace();
        }

        return newDate;
    }
}
