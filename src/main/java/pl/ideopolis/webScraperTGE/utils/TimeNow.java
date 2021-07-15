package pl.ideopolis.webScraperTGE.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeNow {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS");
    private final static Logger log = LoggerFactory.getLogger(TimeNow.class);


    public LocalDate getCurrentTime() {
        log.trace("LocalDate method.");
        return LocalDate.now();
    }

    public String print(LocalDate localDate) {
        log.trace("print method.");
        log.trace("localDate = " + localDate);
        return formatter.format(LocalDate.now());
    }

    public String print(LocalDate localDate, String pattern) {
        log.trace("print method.");
        log.trace("localDate = " + localDate + " ,pattern = " + pattern);
        return DateTimeFormatter.ofPattern(pattern).format(LocalDate.now());
    }

}
