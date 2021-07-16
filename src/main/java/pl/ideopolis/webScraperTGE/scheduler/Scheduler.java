package pl.ideopolis.webScraperTGE.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.ideopolis.webScraperTGE.daneSynoptyczne.SynopticDataService;
import pl.ideopolis.webScraperTGE.daneSynoptyczne.dataModel.SynopticDataDTO;
import pl.ideopolis.webScraperTGE.daneSynoptyczne.dataModel.SynopticDataWrapper;
import pl.ideopolis.webScraperTGE.utils.ConvertDate;
import pl.ideopolis.webScraperTGE.utils.SaveToFile;
import pl.ideopolis.webScraperTGE.utils.SystemProperties;
import pl.ideopolis.webScraperTGE.utils.jsonUtils.Json;

@Component
public class Scheduler {

    private final static Logger log = LoggerFactory.getLogger(Scheduler.class);
    private static final SynopticDataService SYNOPTIC_DATA_SERVICE = new SynopticDataService();

    private static final int SECOND = 1000;
    private static final int MINUTE = 60 * SECOND;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;
    private static final int TIME_INTERVAL_OF_SYNOPTIC_DATA_DOWNLOAD = 20 * MINUTE;

    @Scheduled(fixedRate = TIME_INTERVAL_OF_SYNOPTIC_DATA_DOWNLOAD)
    public void downloadSynopticData() throws JsonProcessingException {
        log.trace("downloadSynopticData method.");
        log.info("Downloading TGE data. Time interval between each download = {}ms", TIME_INTERVAL_OF_SYNOPTIC_DATA_DOWNLOAD);
        final SynopticDataWrapper wrapper = SYNOPTIC_DATA_SERVICE.requestSynopticData();
        wrapper.jsonAsStringToDTOs();
        wrapper.dtosToJson();

        final String fileName = generateFileName(wrapper.getDtos()[0], ".txt");
        SaveToFile.saveToFile(fileName, SystemProperties.getPath(), Json.prettyPrint(wrapper.getJson()));
    }

    private String generateFileName(SynopticDataDTO dto, String fileExtension) {
        log.trace("generateFileName method.");
        return ConvertDate.convertDateToString(dto.getDataPomiaru(), "yyyy-MM-dd") + " " + dto.getGodzinaPomiaru() + fileExtension;
    }

}
