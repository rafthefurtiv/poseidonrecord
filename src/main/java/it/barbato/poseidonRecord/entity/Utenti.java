package it.barbato.poseidonRecord.entity;

import javax.persistence.*;

@Table(name = "utenti", indexes = {
        @Index(name = "utenti_unique_email", columnList = "email", unique = true),
        @Index(name = "utenti_unique_username", columnList = "username", unique = true)
})
@Entity
public class Utenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utente", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 100)
    private String cognome;

    @Column(name = "email", length = 200)
    private String email;

    @Column(name = "username", length = 100)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "codice_sesso", length = 1)
    private String codiceSesso;

    @Column(name = "medaglie_oro", nullable = false)
    private Integer medaglieOro;

    @Column(name = "medaglie_argento", nullable = false)
    private Integer medaglieArgento;

    @Column(name = "medaglie_bronzo", nullable = false)
    private Integer medaglieBronzo;

    @Column(name = "medaglie_oro_staffetta", nullable = false)
    private Integer medaglieOroStaffetta;

    @Column(name = "medaglie_argento_staffetta", nullable = false)
    private Integer medaglieArgentoStaffetta;

    @Column(name = "medaglie_bronzo_staffetta", nullable = false)
    private Integer medaglieBronzoStaffetta;

    @Column(name = "descrizione", length = 1024)
    private String descrizione;

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getMedaglieBronzoStaffetta() {
        return medaglieBronzoStaffetta;
    }

    public void setMedaglieBronzoStaffetta(Integer medaglieBronzoStaffetta) {
        this.medaglieBronzoStaffetta = medaglieBronzoStaffetta;
    }

    public Integer getMedaglieArgentoStaffetta() {
        return medaglieArgentoStaffetta;
    }

    public void setMedaglieArgentoStaffetta(Integer medaglieArgentoStaffetta) {
        this.medaglieArgentoStaffetta = medaglieArgentoStaffetta;
    }

    public Integer getMedaglieOroStaffetta() {
        return medaglieOroStaffetta;
    }

    public void setMedaglieOroStaffetta(Integer medaglieOroStaffetta) {
        this.medaglieOroStaffetta = medaglieOroStaffetta;
    }

    public Integer getMedaglieBronzo() {
        return medaglieBronzo;
    }

    public void setMedaglieBronzo(Integer medaglieBronzo) {
        this.medaglieBronzo = medaglieBronzo;
    }

    public Integer getMedaglieArgento() {
        return medaglieArgento;
    }

    public void setMedaglieArgento(Integer medaglieArgento) {
        this.medaglieArgento = medaglieArgento;
    }

    public Integer getMedaglieOro() {
        return medaglieOro;
    }

    public void setMedaglieOro(Integer medaglieOro) {
        this.medaglieOro = medaglieOro;
    }

    public String getCodiceSesso() {
        return codiceSesso;
    }

    public void setCodiceSesso(String codiceSesso) {
        this.codiceSesso = codiceSesso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}