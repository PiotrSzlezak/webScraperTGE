package pl.ideopolis.webScraperTGE.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ConvertDate {

    public static Optional<LocalDate> convertStringToLocalDate(String dateAsString, String pattern) {
//        System.out.println("  convertStringToLocalDate method");
//        System.out.println("   Date as string: "+dateAsString);
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(dateAsString);
        dateTimeFormatter.format(date);
        return Optional.of(date);
    }

    public static String convertDateToString(LocalDate date, String format){
//        System.out.println("  convertDateToString method");
//        System.out.println("   date = "+date);
//        System.out.println("   format = "+format);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(date);
    }

}
