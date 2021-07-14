package pl.ideopolis.webScraperTGE.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    private static final int SECOND = 1000;
    private static final int MINUTE = 60 * SECOND;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;

    private static final SynopticDataService SYNOPTIC_DATA_SERVICE = new SynopticDataService();


    @Scheduled(fixedRate = 20 * MINUTE)
    public void schedule() throws JsonProcessingException {
        final SynopticDataWrapper wrapper = downloadSynopticData();
        wrapper.jsonAsStringToDTOs();
        wrapper.dtosToJson();

        final String fileName = generateFileName(wrapper.getDtos()[0], ".txt");

        SaveToFile.saveToFile(fileName, SystemProperties.getPath(), Json.prettyPrint(wrapper.getJson()));
        System.out.println("file name: " + fileName);
    }

    private SynopticDataWrapper downloadSynopticData() {
        return SYNOPTIC_DATA_SERVICE.requestSynopticData();
    }

    private String generateFileName(SynopticDataDTO dto, String fileExtension){
        return ConvertDate.convertDateToString(dto.getDataPomiaru(),"yyyy-MM-dd") + " " + dto.getGodzinaPomiaru() + fileExtension;
    }

}
