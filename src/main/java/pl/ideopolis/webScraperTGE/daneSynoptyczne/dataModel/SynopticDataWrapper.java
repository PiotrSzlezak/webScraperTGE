package pl.ideopolis.webScraperTGE.daneSynoptyczne.dataModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.ideopolis.webScraperTGE.utils.jsonUtils.Json;

public class SynopticDataWrapper {

    private String jsonAsString;
    private SynopticDataDTO[] dtos;
    private JsonNode json;

    public SynopticDataWrapper() {
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
        System.out.println("  jsonAsStringToDTOs method");
        ObjectMapper mapper = new ObjectMapper();
        this.dtos = mapper.readValue(this.jsonAsString, SynopticDataDTO[].class);

//        int counter = 1;
//        for (SynopticDataDTO dto : dtos) {
//            System.out.println("DTO " + counter);
//            System.out.println(dto);
//            counter++;
//        }
    }

    public void dtosToJson(){
        json = Json.toJson(dtos);
    }

}
