package it.barbato.poseidonRecord.entity;

import javax.persistence.*;

@Table(name = "stili", indexes = {
        @Index(name = "stili_unique", columnList = "descrizione", unique = true)
})
@Entity
public class Stili {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stile", nullable = false)
    private Integer id;

    @Column(name = "descrizione", nullable = false, length = 48)
    private String descrizione;

    @Column(name = "descrizione_breve", nullable = false, length = 2)
    private String descrizioneBreve;

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrizioneBreve() {
        return descrizioneBreve;
    }

    public void setDescrizioneBreve(String descrizioneBreve) {
        this.descrizioneBreve = descrizioneBreve;
    }
}