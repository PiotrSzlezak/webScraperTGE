package pl.ideopolis.webScraperTGE.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeNow {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS");

    public LocalDate getCurrentTime(){
        return LocalDate.now();
    }

    public String print(LocalDate localDate){
        return formatter.format(LocalDate.now());
    }

    public String print(LocalDate localDate, String pattern){
        return DateTimeFormatter.ofPattern(pattern).format(LocalDate.now());
    }

}
