package it.barbato.poseidonRecord.entity.dto;

public class GaraDto {

    private String nomeGara;
    private String vasca;
    private String categoria;
    private Double tempo;

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
}
