package it.barbato.poseidonRecord.entity;

import javax.persistence.*;



@Table(name = "macchine")
@Entity
public class Macchine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_macchina", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "posti_andata", nullable = false)
    private Integer postiAndata;

    @Column(name = "posti_ritorno", nullable = false)
    private Integer postiRitorno;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    @Column(name = "note", length = 200)
    private String note;

    @ManyToOne(optional = false)
    @JoinColumn(name = "proprietario", nullable = false)
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

    public Integer getPostiAndata() {
        return postiAndata;
    }

    public void setPostiAndata(Integer postiAndata) {
        this.postiAndata = postiAndata;
    }

    public Integer getPostiRitorno() {
        return postiRitorno;
    }

    public void setPostiRitorno(Integer postiRitorno) {
        this.postiRitorno = postiRitorno;
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