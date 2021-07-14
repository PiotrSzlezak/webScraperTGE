package pl.ideopolis.webScraperTGE.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Optional;

public class BigDecimalConvertion {

    public static Optional<BigDecimal> stringToBigDecimal(String string) {
        if (!checkIfStringContainsAtLeastOneDigit(string)){
            return Optional.empty();
        }
        BigDecimal bigDecimal;
        String[] strings = string.split("[0-9]");
        String separator = "";
        int counter = 0;
        for (String s : strings) {
            if (!s.isBlank()) {
                separator = s;
            }
            counter++;
        }
        if (!separator.isBlank()) {
            if (!separator.equals(".")) {
                string = string.replace(separator, ".");
            }
        }
        bigDecimal = new BigDecimal(string);
        return Optional.of(bigDecimal);
    }

    public static boolean checkIfStringContainsAtLeastOneDigit(String numberAsString) {
        Objects.requireNonNull(numberAsString);
        return numberAsString.matches(".*\\d.*");
    }

    public static String bigDecimalToPlainStringIfNotNull(BigDecimal bigDecimal){
        if (Objects.isNull(bigDecimal)){
            return null;
        }
        DecimalFormat formatter = new DecimalFormat("#0.00#");
        return formatter.format(bigDecimal).replace(",", ".");
    }

}
