package pl.ideopolis.webScraperTGE.daneSynoptyczne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.ideopolis.webScraperTGE.daneSynoptyczne.dataModel.SynopticDataWrapper;

@Service
public class SynopticDataService {

    private final RestTemplate restTemplate = new RestTemplate();
    private SynopticDataWrapper wrapper;
    private final static Logger log = LoggerFactory.getLogger(SynopticDataWrapper.class);


    public SynopticDataWrapper requestSynopticData() {
        log.trace("requestSynopticData method.");
        String url = "https://danepubliczne.imgw.pl/api/data/synop";
        wrapper = new SynopticDataWrapper();
        final String json = this.restTemplate.getForObject(url, String.class);
        log.info("JSON downloaded from "+url);
        wrapper.setJsonAsString(json);
        return wrapper;
    }

}
