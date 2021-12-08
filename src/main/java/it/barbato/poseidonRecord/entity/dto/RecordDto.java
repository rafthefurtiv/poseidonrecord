package it.barbato.poseidonRecord.entity.dto;

import java.util.List;

public class RecordDto {

    private String nome;
    private String cognome;
    private String username;
    private String codiceSesso;
    private List<GaraDto> gare;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCodiceSesso() {
        return codiceSesso;
    }

    public void setCodiceSesso(String codiceSesso) {
        this.codiceSesso = codiceSesso;
    }

    public List<GaraDto> getGare() {
        return gare;
    }

    public void setGare(List<GaraDto> gare) {
        this.gare = gare;
    }

}
