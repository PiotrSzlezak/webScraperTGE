package pl.ideopolis.webScraperTGE.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ConvertDate {

    private final static Logger log = LoggerFactory.getLogger(ConvertDate.class);

    public static Optional<LocalDate> convertStringToLocalDate(String dateAsString, String pattern) {
        log.trace("convertStringToLocalDate method. dateAsString = {} ,pattern = {}", dateAsString, pattern);
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(dateAsString);
        dateTimeFormatter.format(date);
        return Optional.of(date);
    }

    public static String convertDateToString(LocalDate date, String format) {
        log.trace("convertDateToString method. date = {} ,format = {}", date, format);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(date);
    }

}
