package pl.ideopolis.webScraperTGE.utils.logger;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.config.ScheduledTask;

public class Logger {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    public static org.slf4j.Logger getLogger(){
        return log;
    }

}
