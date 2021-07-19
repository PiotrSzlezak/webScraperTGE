package pl.ideopolis.webScraperTGE.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemProperties {

    private final static Logger log = LoggerFactory.getLogger(SystemProperties.class);
    private static String resourcePath;
    private static final String osName = System.getProperty("os.name");

    public static String getPath() {
        log.trace("getPath method. osName = {}", osName);
        resourcePath = System.getProperty("user.home")+"/Synoptic data/";
        return resourcePath;
    }
}
