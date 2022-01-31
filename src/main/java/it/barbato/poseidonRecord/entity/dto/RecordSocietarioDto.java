package it.barbato.poseidonRecord.entity.dto;

public class RecordSocietarioDto {

    private String nome;
    private String cognome;
    private String username;
    private String codiceSesso;
    private GaraDto gara;

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

    public GaraDto getGara() {
        return gara;
    }

    public void setGara(GaraDto gara) {
        this.gara = gara;
    }
}
