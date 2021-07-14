package pl.ideopolis.webScraperTGE.daneSynoptyczne.dataModel;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "TgeRdb")
@Table(name = "tge_rdb")
public class SynopticData {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "id_stacji")
    private int idStacji;
    @Column(name = "stacja")
    private String stacja;
    @Column(name = "data_pomiaru")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dataPomiaru;
    @Column(name = "godzina_pomiaru")
    private int godzinaPomiaru;
    @Column(name = "temperatura")
    private BigDecimal temperatura;
    @Column(name = "predkosc_wiatru")
    private BigDecimal predkoscWiatru;
    @Column(name = "kierunek_wiatru")
    private BigDecimal kierunekWiatru;
    @Column(name = "wilgotnosc_wzgledna")
    private BigDecimal wilgotnoscWzgledna;
    @Column(name = "suma_opadu")
    private BigDecimal sumaOpadu;
    @Column(name = "cisnienie")
    private BigDecimal cisnienie;

    public SynopticData() {
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

}
