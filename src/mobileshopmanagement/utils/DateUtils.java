/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileshopmanagement.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author madhu
 */
public class DateUtils {
    private LocalDateTime currentTime = LocalDateTime.now();
    
    public String getTodayDate(){
        LocalDate date = currentTime.toLocalDate();
        return ""+ date;
    }
    
    public String getCurrentTime(){
        LocalTime time = LocalTime.now();
        return "" + time;
    }
}
