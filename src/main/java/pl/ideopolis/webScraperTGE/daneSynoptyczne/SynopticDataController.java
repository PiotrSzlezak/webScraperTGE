package pl.ideopolis.webScraperTGE.daneSynoptyczne;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class SynopticDataController {

    private SynopticDataService synopticDataService = new SynopticDataService();

    @GetMapping("")
    public String getSynopticData() {
        return synopticDataService.requestSynopticData().getJsonAsString();
    }

}
