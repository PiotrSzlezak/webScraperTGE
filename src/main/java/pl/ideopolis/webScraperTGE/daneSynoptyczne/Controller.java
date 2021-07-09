package pl.ideopolis.webScraperTGE.daneSynoptyczne;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class Controller {

    private DaneSynoptyczneService daneSynoptyczneService = new DaneSynoptyczneService();

    @GetMapping("")
    public String getSynopticData (){
        return daneSynoptyczneService.getPostPlainJSON();
    }

}
