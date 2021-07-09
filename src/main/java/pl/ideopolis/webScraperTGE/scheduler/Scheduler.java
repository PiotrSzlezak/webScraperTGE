package pl.ideopolis.webScraperTGE.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;
import pl.ideopolis.webScraperTGE.daneSynoptyczne.DaneSynoptyczneService;
import pl.ideopolis.webScraperTGE.utils.JsonUtil;
import pl.ideopolis.webScraperTGE.utils.SaveToFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    private static final int SECOND = 1000;
    private static final int MINUTE = 60*SECOND;
    private static final int HOUR = 60*MINUTE;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final DaneSynoptyczneService daneSynoptyczneService = new DaneSynoptyczneService();

    @Scheduled(fixedRate = 20*MINUTE)
    public void downloadSynopticData(){
        log.info("The time is now {}", dateFormat.format(new Date()));
        String jsonAsString = daneSynoptyczneService.getPostPlainJSON();

        JsonUtil jsonUtil = new JsonUtil(jsonAsString);
        SaveToFile saveToFile = new SaveToFile();

        String fileName;
        fileName = jsonUtil.getValue("data_pomiaru")+" "+jsonUtil.getValue("godzina_pomiaru")+".txt";
        System.out.println("file name: "+fileName);
        saveToFile.saveToFile(fileName, "D:\\Dane synoptyczne\\", jsonUtil.asText());
    }

}
