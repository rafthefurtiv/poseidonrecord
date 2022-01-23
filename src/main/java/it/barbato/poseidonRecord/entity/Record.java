package it.barbato.poseidonRecord.entity;

import javax.persistence.*;

@Table(name = "record", indexes = {
        @Index(name = "record_unique", columnList = "utente, metri, stile, flag_vasca_corta, flag_societario, categoria", unique = true)
})
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_record", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "utente", nullable = false)
    private Utenti utente;

    @Column(name = "metri", nullable = false)
    private Integer metri;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stile", nullable = false)
    private Stili stile;

    @Column(name = "flag_vasca_corta", nullable = false)
    private Integer flagVascaCorta;

    @Column(name = "flag_societario", nullable = true)
    private Integer flagSocietario;

    @Column(name = "tempo", nullable = false)
    private Double tempo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria", nullable = false)
    private Categorie categoria;

    public Categorie getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorie categoria) {
        this.categoria = categoria;
    }

    public Double getTempo() {
        return tempo;
    }

    public void setTempo(Double tempo) {
        this.tempo = tempo;
    }

    public Integer getFlagSocietario() {
        return flagSocietario;
    }

    public void setFlagSocietario(Integer flagSocietario) {
        this.flagSocietario = flagSocietario;
    }

    public Integer getFlagVascaCorta() {
        return flagVascaCorta;
    }

    public void setFlagVascaCorta(Integer flagVascaCorta) {
        this.flagVascaCorta = flagVascaCorta;
    }

    public Stili getStile() {
        return stile;
    }

    public void setStile(Stili stile) {
        this.stile = stile;
    }

    public Integer getMetri() {
        return metri;
    }

    public void setMetri(Integer metri) {
        this.metri = metri;
    }

    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}