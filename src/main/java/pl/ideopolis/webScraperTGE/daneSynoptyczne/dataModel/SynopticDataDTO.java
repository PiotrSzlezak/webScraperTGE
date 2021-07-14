package pl.ideopolis.webScraperTGE.daneSynoptyczne.dataModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.format.annotation.DateTimeFormat;
import pl.ideopolis.webScraperTGE.utils.BigDecimalConvertion;
import pl.ideopolis.webScraperTGE.utils.ConvertDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class SynopticDataDTO {

    @JsonProperty("id_stacji")
    private int idStacji;
    @JsonProperty("stacja")
    private String stacja;
    @JsonProperty("data_pomiaru")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataPomiaru;
    @JsonProperty("godzina_pomiaru")
    private int godzinaPomiaru;
    @JsonProperty("temperatura")
    private BigDecimal temperatura;
    @JsonProperty("predkosc_wiatru")
    private BigDecimal predkoscWiatru;
    @JsonProperty("kierunek_wiatru")
    private BigDecimal kierunekWiatru;
    @JsonProperty("wilgotnosc_wzgledna")
    private BigDecimal wilgotnoscWzgledna;
    @JsonProperty("suma_opadu")
    private BigDecimal sumaOpadu;
    @JsonProperty("cisnienie")
    private BigDecimal cisnienie;

    public SynopticDataDTO() {
    }

    public SynopticDataDTO(JsonNode node){
        this.idStacji = Integer.parseInt(node.path("id_stacji").asText());
        this.stacja = node.path("stacja").asText();
        final Optional<LocalDate> data_pomiaru = ConvertDate.convertStringToLocalDate(node.path("data_pomiaru").asText(), "yyyy-MM-dd");
        data_pomiaru.ifPresent(localDate -> this.dataPomiaru = localDate);
        this.godzinaPomiaru = Integer.parseInt(node.path("godzina_pomiaru").asText());
        final Optional<BigDecimal> temperatura = BigDecimalConvertion.stringToBigDecimal(node.path("temperatura").asText());
        temperatura.ifPresent(bigDecimal -> this.temperatura = bigDecimal);
        final Optional<BigDecimal> predkosc_wiatru = BigDecimalConvertion.stringToBigDecimal(node.path("predkosc_wiatru").asText());
        predkosc_wiatru.ifPresent(bigDecimal -> this.predkoscWiatru = bigDecimal);
        final Optional<BigDecimal> kierunek_wiatru = BigDecimalConvertion.stringToBigDecimal(node.path("kierunek_wiatru").asText());
        kierunek_wiatru.ifPresent(bigDecimal -> this.kierunekWiatru = bigDecimal);
        final Optional<BigDecimal> wilgotnosc_wzgledna = BigDecimalConvertion.stringToBigDecimal(node.path("wilgotnosc_wzgledna").asText());
        wilgotnosc_wzgledna.ifPresent(bigDecimal -> this.wilgotnoscWzgledna = bigDecimal);
        final Optional<BigDecimal> suma_opadu = BigDecimalConvertion.stringToBigDecimal(node.path("suma_opadu").asText());
        suma_opadu.ifPresent(bigDecimal -> this.sumaOpadu = bigDecimal);
        final Optional<BigDecimal> cisnienie = BigDecimalConvertion.stringToBigDecimal(node.path("cisnienie").asText());
        cisnienie.ifPresent(bigDecimal -> this.cisnienie = bigDecimal);
    }


    public int getIdStacji() {
        return idStacji;
    }

    public String getStacja() {
        return stacja;
    }

    public LocalDate getDataPomiaru() {
        return dataPomiaru;
    }

    public int getGodzinaPomiaru() {
        return godzinaPomiaru;
    }

    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public BigDecimal getPredkoscWiatru() {
        return predkoscWiatru;
    }

    public BigDecimal getKierunekWiatru() {
        return kierunekWiatru;
    }

    public BigDecimal getWilgotnoscWzgledna() {
        return wilgotnoscWzgledna;
    }

    public BigDecimal getSumaOpadu() {
        return sumaOpadu;
    }

    public BigDecimal getCisnienie() {
        return cisnienie;
    }


    public void setIdStacji(int idStacji) {
        this.idStacji = idStacji;
    }

    public void setStacja(String stacja) {
        this.stacja = stacja;
    }

    public void setDataPomiaru(LocalDate dataPomiaru) {
        this.dataPomiaru = dataPomiaru;
    }

    public void setDataPomiaru(String dataPomiaru) {
        final Optional<LocalDate> localDate = ConvertDate.convertStringToLocalDate(dataPomiaru, "yyyy-MM-dd");
        this.dataPomiaru = localDate.orElse(null);
    }

    public void setGodzinaPomiaru(int godzinaPomiaru) {
        this.godzinaPomiaru = godzinaPomiaru;
    }

    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

    public void setPredkoscWiatru(BigDecimal predkoscWiatru) {
        this.predkoscWiatru = predkoscWiatru;
    }

    public void setKierunekWiatru(BigDecimal kierunekWiatru) {
        this.kierunekWiatru = kierunekWiatru;
    }

    public void setWilgotnoscWzgledna(BigDecimal wilgotnoscWzgledna) {
        this.wilgotnoscWzgledna = wilgotnoscWzgledna;
    }

    public void setSumaOpadu(BigDecimal sumaOpadu) {
        this.sumaOpadu = sumaOpadu;
    }

    public void setCisnienie(BigDecimal cisnienie) {
        this.cisnienie = cisnienie;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id_stacji : ").append(idStacji)
                .append("\nstacja : ").append(stacja)
                .append("\ndata_pomiaru : ").append(ConvertDate.convertDateToString(dataPomiaru, "yyyy-MM-dd"))
                .append("\ngodzina_pomiaru : ").append(godzinaPomiaru)
                .append("\ntemperatura : ").append(bigDecimalToPlainStringIfNotNull(temperatura))
                .append("\npredkosc_wiatru : ").append(bigDecimalToPlainStringIfNotNull(predkoscWiatru))
                .append("\nkierunek_wiatru : ").append(bigDecimalToPlainStringIfNotNull(kierunekWiatru))
                .append("\nwilgotnosc_wzgledna : ").append(bigDecimalToPlainStringIfNotNull(wilgotnoscWzgledna))
                .append("\nsuma_opadu : ").append(bigDecimalToPlainStringIfNotNull(sumaOpadu))
                .append("\ncisnienie : ").append(bigDecimalToPlainStringIfNotNull(cisnienie));
        return sb.toString();
    }

    private String bigDecimalToPlainStringIfNotNull(BigDecimal bigDecimal){
        if (Objects.isNull(bigDecimal)){
            return null;
        }
        return bigDecimal.toPlainString();
    }

}
