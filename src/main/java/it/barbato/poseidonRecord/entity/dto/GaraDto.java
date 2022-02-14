package it.barbato.poseidonRecord.entity.dto;

public class GaraDto {

    private String nomeGara;
    private String vasca;
    private String categoria;
    private Double tempo;
    private String metri;
    private String stile;


    public String getNomeGara() {
        return nomeGara;
    }

    public void setNomeGara(String nomeGara) {
        this.nomeGara = nomeGara;
    }

    public String getVasca() {
        return vasca;
    }

    public void setVasca(String vasca) {
        this.vasca = vasca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getTempo() {
        return tempo;
    }

    public void setTempo(Double tempo) {
        this.tempo = tempo;
    }

    public String getMetri() {
        return metri;
    }

    public void setMetri(String metri) {
        this.metri = metri;
    }

    public String getStile() {
        return stile;
    }

    public void setStile(String stile) {
        this.stile = stile;
    }
}
