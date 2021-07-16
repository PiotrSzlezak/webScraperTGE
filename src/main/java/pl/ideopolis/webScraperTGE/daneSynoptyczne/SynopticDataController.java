package pl.ideopolis.webScraperTGE.daneSynoptyczne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class SynopticDataController {

    private final static Logger log = LoggerFactory.getLogger(SynopticDataController.class);

    private SynopticDataService synopticDataService = new SynopticDataService();

    @GetMapping("")
    public String getSynopticData() {
        log.trace("getSynopticData method.");
        log.info("Get request at \"/\" received to get synoptic data.");
        return synopticDataService.requestSynopticData().getJsonAsString();
    }

}
