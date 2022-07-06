package com.hrms.gateservice;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Hash{
    
    public static void main(String[] args) {
        //  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //  System.out.println("encode: "+ encoder.encode("abc"));
        
        // Date toDate = stringToDate("2022/06/29", "yyyy/mm/dd");
        // Date fromDate = stringToDate("2022/06/30", "yyyy/mm/dd");

        // long days = Math.abs(toDate.getTime()-fromDate.getTime());
        // System.out.println(days);
        // days = TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);

        // System.out.println(LocalDate.parse("2022-06-30").plusDays(1).toString());
    }

    public static Date stringToDate(String time, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date=null;
        try{
            date = format.parse(time);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return date;
    }
  
    
}
