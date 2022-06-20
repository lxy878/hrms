package com.hrms.gateservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Hash{
    
    public static void main(String[] args) {
         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //  System.out.println("encode: "+ encoder.encode("abc"));

        String s1 = "12:31:39";
        String s2 = "13:31:39";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        long difference = 0;
        try {
            Date date1 = format.parse(s1);
            Date date2 = format.parse(s2);
            difference = date2.getTime() - date1.getTime();

        } catch (ParseException e) {
            
            e.printStackTrace();
        }
        System.out.println(difference/1000/60/60);
    }
}
