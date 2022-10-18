package it.barbato.poseidonRecord.entity;

import javax.persistence.*;
import java.util.List;


/*
@Table(name = "macchine", indexes = {
        @Index(name = "utenti_unique_email", columnList = "email", unique = true),
        @Index(name = "utenti_unique_username", columnList = "username", unique = true)
})

 */

@Entity
public class Macchine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_macchina", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "posti", nullable = false)
    private Integer posti;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    @Column(name = "note", length = 200)
    private String note;

    @Column(name = "proprietario", nullable = false)
    private Utenti proprietario;

    @Column(name = "andata", nullable = false)
    private Boolean andata;

    @Column(name = "ritorno", nullable = false)
    private Boolean ritorno;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPosti() {
        return posti;
    }

    public void setPosti(Integer posti) {
        this.posti = posti;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Utenti getProprietario() {
        return proprietario;
    }

    public void setProprietario(Utenti proprietario) {
        this.proprietario = proprietario;
    }

    public Boolean getAndata() {
        return andata;
    }

    public void setAndata(Boolean andata) {
        this.andata = andata;
    }

    public Boolean getRitorno() {
        return ritorno;
    }

    public void setRitorno(Boolean ritorno) {
        this.ritorno = ritorno;
    }
}