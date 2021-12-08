package it.barbato.poseidonRecord.entity.dto;


public class NewRecordDto {

    private Integer idUtente;
    private Integer metri;
    private Integer idStile;
    private Integer idCategoria;
    private Integer vasca;
    private Integer minuti;
    private Integer secondi;
    private Integer centesimi;

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public Integer getMetri() {
        return metri;
    }

    public void setMetri(Integer metri) {
        this.metri = metri;
    }

    public Integer getIdStile() {
        return idStile;
    }

    public void setIdStile(Integer idStile) {
        this.idStile = idStile;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getMinuti() {
        return minuti;
    }

    public void setMinuti(Integer minuti) {
        this.minuti = minuti;
    }

    public Integer getSecondi() {
        return secondi;
    }

    public void setSecondi(Integer secondi) {
        this.secondi = secondi;
    }

    public Integer getCentesimi() {
        return centesimi;
    }

    public void setCentesimi(Integer centesimi) {
        this.centesimi = centesimi;
    }

    public Integer getVasca() {
        return vasca;
    }

    public void setVasca(Integer vasca) {
        this.vasca = vasca;
    }
}
