package pl.ideopolis.webScraperTGE.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemProperties {

    private static String resourcePath;
    private static final String osName = System.getProperty("os.name");
    private final static Logger log = LoggerFactory.getLogger(SystemProperties.class);

    public static String getPath() {
        log.trace("getPath method.");
        log.trace("os name = " + osName);
        switch (osName) {
            case "Linux":
                resourcePath = "/media/piotr/Data/Dane synoptyczne/";
                break;
            case "Windows 10":
                resourcePath = "D:/Dane synoptyczne/";
                break;
        }
        return resourcePath;
    }
}
