package pl.ideopolis.webScraperTGE.daneSynoptyczne.dataModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ideopolis.webScraperTGE.utils.jsonUtils.Json;

public class SynopticDataWrapper {

    private final static Logger log = LoggerFactory.getLogger(SynopticDataWrapper.class);

    private String jsonAsString;
    private SynopticDataDTO[] dtos;
    private JsonNode json;

    public SynopticDataWrapper() {
        log.trace("No parameter constructor.");
    }

    public String getJsonAsString() {
        return jsonAsString;
    }

    public void setJsonAsString(String jsonAsString) {
        this.jsonAsString = jsonAsString;
    }

    public SynopticDataDTO[] getDtos() {
        return dtos;
    }

    public void setDtos(SynopticDataDTO[] dtos) {
        this.dtos = dtos;
    }

    public JsonNode getJson() {
        return json;
    }

    public void setJson(JsonNode json) {
        this.json = json;
    }

    public void jsonAsStringToDTOs() throws JsonProcessingException {
        log.trace("jsonAsStringToDTOs method.");
        ObjectMapper mapper = new ObjectMapper();
        this.dtos = mapper.readValue(this.jsonAsString, SynopticDataDTO[].class);
        log.trace("jsonAsStringToDTOs method mapped {} DTOs", dtos.length);
    }

    public void dtosToJson() {
        log.trace("dtosToJson method.");
        json = Json.toJson(dtos);
    }

}
