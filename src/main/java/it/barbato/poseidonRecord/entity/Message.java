package it.barbato.poseidonRecord.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "message")

@Data
@Getter
@Setter
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_messaggio", nullable = false)
    private Integer id;

    @Column(name = "messaggio", nullable = false, length = 100)
    private String messaggio;

    @Column(name = "owner", nullable = false, length = 100)
    private String owner;

    @Column(name = "timestamp", nullable = false, length = 200)
    private Timestamp timestamp;

}