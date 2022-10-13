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
    private Integer andata;

    @Column(name = "ritorno", nullable = false)
    private Integer ritorno;

}