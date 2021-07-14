package pl.ideopolis.webScraperTGE.daneSynoptyczne;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.ideopolis.webScraperTGE.daneSynoptyczne.dataModel.SynopticDataWrapper;

@Service
public class SynopticDataService {

    private final RestTemplate restTemplate = new RestTemplate();
    private SynopticDataWrapper wrapper;

    public SynopticDataWrapper requestSynopticData() {
        String url = "https://danepubliczne.imgw.pl/api/data/synop";
        System.out.println("Dżejson pobrany");
        wrapper = new SynopticDataWrapper();
        wrapper.setJsonAsString(this.restTemplate.getForObject(url, String.class));
        return wrapper;
    }

}
