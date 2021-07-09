package pl.ideopolis.webScraperTGE.daneSynoptyczne;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DaneSynoptyczneService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getPostPlainJSON(){
        String url = "https://danepubliczne.imgw.pl/api/data/synop";
        System.out.println("Dżejson pobrany");
        return this.restTemplate.getForObject(url, String.class);
    }

}
