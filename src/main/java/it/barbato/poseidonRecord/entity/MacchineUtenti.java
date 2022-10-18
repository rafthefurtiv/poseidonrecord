package it.barbato.poseidonRecord.entity;

import it.barbato.poseidonRecord.service.MacchineService;

import javax.persistence.*;
import java.util.List;

/*
@Table(name = "macchine", indexes = {
        @Index(name = "utenti_unique_email", columnList = "email", unique = true),
        @Index(name = "utenti_unique_username", columnList = "username", unique = true)
})

 */
@Entity
public class MacchineUtenti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_macchina_utente", nullable = false)
    private Integer id;

    @Column(name = "macchina", nullable = false, length = 100)
    private Macchine macchina;

    @Column(name = "passeggero", nullable = false)
    private Utenti passeggero;

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

    public Macchine getMacchina() {
        return macchina;
    }

    public void setMacchina(Macchine macchina) {
        this.macchina = macchina;
    }

    public Utenti getPasseggero() {
        return passeggero;
    }

    public void setPasseggero(Utenti passeggero) {
        this.passeggero = passeggero;
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